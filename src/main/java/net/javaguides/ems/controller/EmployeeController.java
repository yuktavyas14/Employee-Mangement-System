package net.javaguides.ems.controller;


import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employe;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("")
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok().body(employeeService.addEmployee(employeeDto));
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllList(){
        return ResponseEntity.ok().body(employeeService.employeeList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(employeeService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmploye(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return ResponseEntity.ok().body(employeeService.updateEmployee(id,employeeDto));
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<String> deleteid(@PathVariable Long id){
        employeeService.deleteEmployeById(id);
        return ResponseEntity.ok("Employee Delete Succesfylly");
    }
}
