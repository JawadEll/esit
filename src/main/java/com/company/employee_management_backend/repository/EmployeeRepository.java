package com.company.employee_management_backend.repository;

import com.company.employee_management_backend.entity.Employee;
import com.company.employee_management_backend.repository.pattern_repository.GenericRepository;

public interface EmployeeRepository extends GenericRepository<Employee, Long> {
/*pour toute crud sont déja hérité par GeniriqueRepository et aussi on peut ajouter des methode personnalisé */


}
