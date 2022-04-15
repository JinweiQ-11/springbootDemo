package org.example.dao;
import org.example.entity.Project;

import java.util.List;
import java.util.Map;

public interface ProjectDao {
    //public List<ProjectDao> getProjectList(Map<String, Object> map);
    public int insertProject(Map<String, Object> map);
    public List<Project> getProjectList(Map<String, Object> map);
    public void updateProjectStatus(Map<String, Object> map);

}
