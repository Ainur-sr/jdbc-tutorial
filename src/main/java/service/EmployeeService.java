package service;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import entity.Employee;

import java.util.List;

public class EmployeeService {

    private final EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public void add(Employee employee){
        employeeDAO.add(employee);
    }

    public List<Employee> getAll(){
        return employeeDAO.getAll();
    }

    public Employee getById(Long id){
        return employeeDAO.getById(id);
    }

    public void update(Employee employee){
        employeeDAO.update(employee);
    }

    public void remove(Employee employee){
        employeeDAO.remove(employee);
    }
}
