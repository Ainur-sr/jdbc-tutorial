package dao;

import entity.EmplProj;

import java.util.List;

public interface EmplProjDAO {

    void add(EmplProj emplProj);

    List<EmplProj> getAll();

    EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId);

    void update(EmplProj emplProj);

    void remove(EmplProj emplProj);
}
