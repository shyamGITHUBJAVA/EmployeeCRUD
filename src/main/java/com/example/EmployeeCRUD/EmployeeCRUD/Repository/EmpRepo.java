package com.example.EmployeeCRUD.EmployeeCRUD.Repository;

import com.example.EmployeeCRUD.EmployeeCRUD.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {
}
