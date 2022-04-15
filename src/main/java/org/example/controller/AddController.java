package org.example.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.example.entity.Product;
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
 * @date ：Created in 2022/3/25 23:10
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@RequestMapping("project")
public class AddController {
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProjectService projectService;
    @Autowired
    ProductService productService;
    @Autowired
    private UserService userService;
    @PostMapping("/createProject")
    @ResponseBody
    @Transactional
    public Map<String,Object> createProject(@RequestBody String inJsonString, HttpServletRequest request)  throws Exception{
        Map result = new HashMap();
        try {
            Map<String, Object> queryMap = JSONObject.parseObject(inJsonString, Map.class);
            logger.info(inJsonString);
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
            List fdAttr = new ArrayList();
            fdAttr = (List) queryMap.get("fdAttr");
            if (fdAttr.isEmpty()){
                result.put("status","ERROR");
                result.put("message","属性不能为空!");
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
            JSONArray jsonArray=new JSONArray(fdAttr);
            queryMap.put("fdProductAttr1",jsonArray.toString());
            //添加属性
            productService.updateProduct(queryMap);
            result.put("status","OK");
            result.put("message","插入成功!");
        }catch (Exception e){
            if(e instanceof DuplicateKeyException){
                result.put("message","项目信息重复,请检查");
            }else {
                result.put("message","插入失败");
            }
            logger.error(e.getMessage());
            result.put("status","ERROR");
        }
        result.put("data",inJsonString);
        return result;
    }

}
