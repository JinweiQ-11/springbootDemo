package org.example.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.example.entity.Product;
import org.example.entity.Project;
import org.example.entity.User;
import org.example.service.ProductService;
import org.example.service.ProjectService;
import org.example.service.UserService;
import org.example.utils.ProjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/3/24 22:29
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("project")

public class ProjectController {
    private Logger logger = LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    ProductService productService;
    /**
      * @Author qinjinwei
      * @FunName addProject
      * @Description 创建
      * @Date 23:11 2022/3/24
      * @Param [inJsonString, request]
      * @return java.util.Map<java.lang.String,java.lang.Object>
      **/
    @PostMapping("/addProject")
    @ResponseBody
    @Transactional
    public Map<String,Object> addProject(@RequestBody String inJsonString, HttpServletRequest request)  throws Exception{
        Map result = new HashMap();
        try {
            Map<String, Object> queryMap = JSONObject.parseObject(inJsonString, Map.class);
            Boolean isVaild = true;
            if (queryMap.get("fdProjectName")!=null && StringUtils.isEmpty(queryMap.get("fdProjectName").toString())) {
                result.put("status", "ERROR");
                result.put("message", "传入的项目名称为空!");
                isVaild = false;
            }

            if (queryMap.get("fdProjectManager")==null) {
                result.put("status", "ERROR");
                result.put("message", "传入的项目经理为null!");
                return result;
            }
            String fdProjectManager = queryMap.get("fdProjectManager").toString();
            if (StringUtils.isEmpty(fdProjectManager)){
                result.put("status", "ERROR");
                result.put("message", "传入的项目经理为空!");
                return result;
            }
            List<User> userList = new ArrayList<>();
            List<Product> productList = new ArrayList<>();
            queryMap.put("loginName",fdProjectManager);
            userList = userService.getUserList(queryMap);
            if (userList.isEmpty()){
                result.put("status","ERROR");
                result.put("message","用户不存在");
                isVaild = false;
            }
            productList = productService.getProductList(queryMap);
            if (productList.isEmpty()){
                result.put("status","ERROR");
                result.put("message","产品类型为空!");
                isVaild = false;
            }
            if (!isVaild ){
                return result;
            }
            String userId = userList.get(0).getUserId();
            String fdProductId = productList.get(0).getFdProductId();
            queryMap.put("fdProductId",fdProductId);
            queryMap.put("fdProjectManager",userId);
            queryMap.put("fdProjectId", ProjectUtils.getUUID());
            projectService.insertProjectInfo(queryMap);
            result.put("status","OK");
            result.put("message","插入成功!");
        }catch (Exception e){
            logger.error("e");
            if(e instanceof DuplicateKeyException){
                result.put("message","项目信息重复,请检查");
            }else {
                result.put("message","插入失败");
            }
            logger.error(e.getMessage());
            result.put("status","ERROR");
        }
        return result;
    }

    @PostMapping("/getProject")
    @ResponseBody
    @Transactional
    public Map<String,Object> getProject(@RequestBody String inJsonString, HttpServletRequest request)  throws Exception{
        Map result = new HashMap();
        try {
            Map<String, Object> queryMap = JSONObject.parseObject(inJsonString, Map.class);
            if (queryMap.get("fdProjectName")!=null && StringUtils.isEmpty(queryMap.get("fdProjectName").toString())) {
                result.put("status", "ERROR");
                result.put("message", "传入的项目名称为空!");
                return result;
            }
            List <Project> projectList = projectService.queryProjectInfo(queryMap);
            projectList.forEach(project->{
                if (!StringUtils.isEmpty(project.getFdProjectStatus())){
                    project.setFdProjectStatus(ProjectUtils.getCode(project.getFdProjectStatus()));
                }
            });
            result.put("status","OK");
            result.put("message","查询成功!");
            result.put("projectList",projectList);
        }catch (Exception e){
            result.put("message","查询失败!");
            logger.error(e.getMessage());
            result.put("status","ERROR");
        }
        return result;
    }


    @PostMapping("/updateProjectStatus")
    @ResponseBody
    @Transactional
    public Map<String,Object> updateProjectInfo(@RequestBody String inJsonString, HttpServletRequest request)  throws Exception{
        Map result = new HashMap();
        try {
            Map<String, Object> queryMap = JSONObject.parseObject(inJsonString, Map.class);
            if (queryMap.get("fdProjectName")==null || StringUtils.isEmpty(queryMap.get("fdProjectName").toString())) {
                result.put("status", "ERROR");
                result.put("message", "传入的项目名称为空!");
                return result;
            }
            Object fdProjectStatus = queryMap.get("fdProjectStatus");
            if (fdProjectStatus==null || StringUtils.isEmpty(fdProjectStatus.toString())) {
                result.put("status", "ERROR");
                result.put("message", "传入的项目状态不能为空!");
                return result;
            }
            queryMap.put("fdProjectStatus",ProjectUtils.getCode(fdProjectStatus.toString()));
            Object fdProductCname = queryMap.get("fdProductCname");
            if (fdProductCname!=null && !StringUtils.isEmpty(fdProductCname.toString())){
                List<Product> productList = productService.getProductList(queryMap);
                if (!productList.isEmpty()){
                    queryMap.put("fdProductId",productList.get(0).getFdProductId());
                }
            }
            projectService.updateProjectInfo(queryMap);
            productService.updateProduct(queryMap);
            result.put("status","OK");
            result.put("message","更新成功!");
        }catch (Exception e){
            result.put("message","更新失败!");
            logger.error(e.getMessage());
            System.out.println(e.getMessage());
            System.out.println(e.fillInStackTrace());
            result.put("status","ERROR");
        }
        return result;
    }




}
