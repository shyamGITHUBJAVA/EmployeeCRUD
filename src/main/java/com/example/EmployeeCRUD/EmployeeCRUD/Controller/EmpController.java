package com.example.EmployeeCRUD.EmployeeCRUD.Controller;

import com.example.EmployeeCRUD.EmployeeCRUD.Entity.Employee;
import com.example.EmployeeCRUD.EmployeeCRUD.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return empService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeebyID(@PathVariable long id) {
        Employee employee = empService.getEmpByID(id);
        return ResponseEntity.ok(employee);
    }
    @PostMapping("/save")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee e){
        Employee employee = empService.createEmployee(e);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id){
        empService.deleteEmployee(id);
        return "deleted the particular employee";
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee e){
            Employee updatedEmployee = empService.updateEmp(id,e);
            return ResponseEntity.ok(updatedEmployee);
     }


}

