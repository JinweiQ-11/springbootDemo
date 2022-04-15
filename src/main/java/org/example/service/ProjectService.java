package org.example.service;

import org.example.entity.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    public Map insertProjectInfo (Map<String,Object> projectInfo);
    public List<Project> queryProjectInfo (Map<String,Object> projectInfo);
    public void updateProjectInfo (Map<String,Object> projectInfo);


}
