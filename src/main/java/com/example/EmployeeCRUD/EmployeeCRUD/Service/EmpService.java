package com.example.EmployeeCRUD.EmployeeCRUD.Service;

import com.example.EmployeeCRUD.EmployeeCRUD.Entity.Employee;
import com.example.EmployeeCRUD.EmployeeCRUD.Repository.EmpRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {
    @Autowired
    private EmpRepo empRepo;

    public List<Employee> getEmployees(){
        return empRepo.findAll();
    }

    public Employee getEmpByID(long id){
        Optional<Employee> employee = empRepo.findById(id);

        if(employee.isPresent()){
            return employee.get();
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"user not found with the id");
        }
    }

    public Employee createEmployee(Employee e){
        return empRepo.save(e);
    }
    public void deleteEmployee(long id){
        empRepo.deleteById(id);
    }

    public Employee updateEmp(long id, Employee nemp){
        Employee existing = empRepo.findById(id).orElse(null);
        if(existing==null) {
            throw new RuntimeException("employee not found with id" + id);
        }
            existing.setFirst_Name(nemp.getFirst_Name());
            existing.setLast_Name(nemp.getLast_Name());
            existing.setEmail(nemp.getEmail());
            existing.setPassword(nemp.getPassword());

            return empRepo.save(existing);
    }
}
