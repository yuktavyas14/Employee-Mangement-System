package net.javaguides.ems.repositiory;

import net.javaguides.ems.entity.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepositiory extends JpaRepository<Employe,Long> {
}
