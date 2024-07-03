package net.javaguides.ems.service.impl;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employe;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.repositiory.EmployeeRepositiory;
import net.javaguides.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final EmployeeRepositiory employeeRepositiory;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepositiory employeeRepositiory, EmployeeMapper employeeMapper) {
        this.employeeRepositiory = employeeRepositiory;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employe employee=employeeMapper.toEntity(employeeDto);
        employee=employeeRepositiory.save(employee);
        return employeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> employeeList() {
        List<Employe> employeList=employeeRepositiory.findAll();
        return employeeMapper.toDto(employeList);
    }

    @Override
    public EmployeeDto getById(Long id) throws RuntimeException {
        Optional<Employe> employe=employeeRepositiory.findById(id);
        if(employe.isPresent()){
            return employeeMapper.toDto(employe.get());
        }
      else{
          throw new RuntimeException("No Employe Found for this id : {}");
        }
    }

    @Override
    public EmployeeDto updateEmployee( Long id ,EmployeeDto updatedEmploye) {
     Employe employe= employeeRepositiory.findById(id).orElseThrow(()->new RuntimeException("id does not exist"));

         employe.setFirstName(updatedEmploye.getFirstName());
         employe.setLastName(updatedEmploye.getLastName());
         employe.setEmail(updatedEmploye.getEmail());
        Employe updateEmployeObj=employeeRepositiory.save(employe);
        return employeeMapper.toDto(updateEmployeObj);
    }

    @Override
    public void deleteEmployeById(Long id) {
        Employe employe=employeeRepositiory.findById(id).orElseThrow(()->new RuntimeException("Id does not exist"));
       employeeRepositiory.deleteById(id);

    }
}
