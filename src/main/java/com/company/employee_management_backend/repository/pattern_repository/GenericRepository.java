package com.company.employee_management_backend.repository.pattern_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

//cette interface Sert de base commune à tous les repositories.


@NoRepositoryBean
/*“Ne crée pas de bean pour cette interface,
 mais laisse les sous-interfaces (UserRepository, EmployeeRepository…) être des beans.
 beans? => C’est tout le cycle de vie :

 Instanciation automatique(new)

Injection des dépendances (avec @Autowired ou constructeur)

Configuration (propriétés, valeurs)

Gestion du scope (singleton, prototype…)

Destruction (si nécessaire)
 */

public interface GenericRepository<T,ID> extends JpaRepository<T,ID>{

    /*de plus +  ici je peux ajouter des methode personnaliser pour toute les sous interface */

}


