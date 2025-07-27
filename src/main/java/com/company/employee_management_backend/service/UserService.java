package com.company.employee_management_backend.service;

import com.company.employee_management_backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //creation de User
    User createUser(User user);

    // lister tous les user
     List<User> getAllUsers();


     /*Optional  pour éviter null au cas ou objet non trouver et aussi éviter NullPointerException en niveaux d'implementation
    methode utiliser par Optional
    =>  isPresent()Vérifie si une valeur est présente
        , ifPresent() Exécute un bloc si la valeur existe,
         orElse(T autreValeur)
         , orElseThrow() lance une expception si null
*/
    Optional<User> getUserById(Long id);


    void deleteUser(Long id);

//User user parametre pour les nv donner changable
    User updateUser(Long id , User user);
}
