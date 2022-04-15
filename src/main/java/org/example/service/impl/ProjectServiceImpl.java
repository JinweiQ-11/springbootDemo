package org.example.service.impl;

import com.alibaba.fastjson.JSON;
import org.example.dao.ProjectDao;
import org.example.entity.Project;
import org.example.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author ：qinjinwei
 * @date ：Created in 2022/3/24 22:08
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectDao projectDao;

    @Override
    public Map insertProjectInfo(Map insert){
        projectDao.insertProject(insert);
        return insert;
    }

    @Override
    public List<Project> queryProjectInfo(Map<String, Object> queryMap) {
        return projectDao.getProjectList(queryMap);
    }

    @Override
    public void updateProjectInfo(Map<String, Object> projectInfo) {
        projectDao.updateProjectStatus(projectInfo);
    }
}
