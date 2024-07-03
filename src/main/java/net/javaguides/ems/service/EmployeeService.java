package net.javaguides.ems.service;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employe;

import java.util.List;

public interface EmployeeService {

    EmployeeDto addEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> employeeList();

    EmployeeDto getById(Long id) throws RuntimeException;

    EmployeeDto updateEmployee(Long id,EmployeeDto updatedEmploye);

    void deleteEmployeById(Long id);
}
