package com.company.employee_management_backend.entity;
import com.company.employee_management_backend.entity.enumm.Departement;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data @Builder @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name ="employees")

public class Employee implements Serializable {
    private  static final long serializableVersionUID = 1L ;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable =false)
    private String name;
    @Column(nullable =false)
    private String address;
    @Column(nullable =false , unique= true)
    private String phone;
    @Column(nullable =false , unique= true)
    private String email;

    @Enumerated(EnumType.STRING )
    private Departement department;

    private Double salary;
  private LocalDate birthday;

  // relation avec manager

    /*        @ManyToOne
       @JoinColumn(name="manager_id")
        private Manager  ¤¤ manager ¤¤;

     */
   @ManyToOne
   @JoinColumn(name = "manager_id",
   nullable = false)
    private User manager;



}
