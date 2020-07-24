package service;

import dao.EmplProjDAO;
import dao.EmplProjDAOImpl;
import entity.EmplProj;

import java.util.List;

public class EmplProjService {

    private final EmplProjDAO emplProjDAO = new EmplProjDAOImpl();

    public void add(EmplProj emplProj){
        emplProjDAO.add(emplProj);
    }

    public List<EmplProj> getAll(){
        return emplProjDAO.getAll();
    }

    public EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId){
        return emplProjDAO.getByEmployeeIdAndProjectId(employeeId, projectId);
    }

    public void update(EmplProj emplProj){
        emplProjDAO.update(emplProj);
    }

    public void remove(EmplProj emplProj){
        emplProjDAO.remove(emplProj);
    }
}
