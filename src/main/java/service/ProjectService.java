package service;

import dao.ProjectDAO;
import dao.ProjectDAOImpl;
import entity.Project;

import java.util.List;

public class ProjectService {

    private final ProjectDAO projectDAO = new ProjectDAOImpl();

    public void add(Project project){
        projectDAO.add(project);
    }

    public List<Project> getAll(){
        return projectDAO.getAll();
    }

    public Project getById(Long id){
        return projectDAO.getById(id);
    }

    public void update(Project project){
        projectDAO.update(project);
    }

    public void remove(Project project){
        remove(project);
    }
}
