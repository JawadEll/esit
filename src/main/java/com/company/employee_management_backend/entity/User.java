package com.company.employee_management_backend.entity;

import com.company.employee_management_backend.entity.enumm.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data  //getter /setter (muttateur)
@AllArgsConstructor //Constructor par tout paramétre
@NoArgsConstructor //constructuer par default
@Builder  //c'est un pattern pour ne pas écrire beaucoupe dont le parametre de constructeur (simplification) ou crerer des objets facilement

@Entity /*pour bien mapper cette class en DB (Entité JPA)*/@Table(name = "users")/* Donne le nom de la table dans la DB */


public class User  {
    @Id //pour dire que c'est un cle primaire via JPA/Hiberte
    @GeneratedValue/*dit au hibernet de generer automatiquement  la valeur  */(strategy =
            GenerationType.IDENTITY)/*C'est au*/
    private Long id ;

    @Enumerated(EnumType.STRING) /*Sans cette annotation, Hibernate ne sait pas comment stocker l’énumération (Role) en BD*/
    private Role role;

    @Column(nullable = false , unique = true )// nullable flase (ce champ est obligatoire est unique =True Pas deux utilisateurs avec le même nom )
private String username;

    @Column(nullable = false)
private String password ;

/*
     Uniquement pour Admin  sa va etre adapter en servicemais logiquement,
     seulement les MANAGERS auront une liste.
    ➡ Ce contrôle doit être fait dans le Service, pas en JPA
  */
    @OneToMany(mappedBy = "manager")
    private List<Employee> employees;
}

