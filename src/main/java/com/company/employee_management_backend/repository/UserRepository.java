package com.company.employee_management_backend.repository;

import com.company.employee_management_backend.entity.User;
import com.company.employee_management_backend.repository.pattern_repository.GenericRepository;

import java.util.Optional;


public interface UserRepository extends GenericRepository<User,Long> {
/*
on  écris seulement les méthodes personnalisées (findByUsername, existsByEmail, etc.).
              {les crud} sont Heriter via -> GenericRepository ->inteface generique  JpaRepository
 méthodes héritées automatiquement par JpaRepository<T, ID> (tu n’as PAS besoin de les réécrire) :
 | **Catégorie**        | **Méthode**                                           | **Description**                          |
| -------------------- | ----------------------------------------------------- | ---------------------------------------- |
| **CREATE / UPDATE**  | `<S extends T> S save(S entity)`                      | Crée ou met à jour une entité            |
|                      | `<S extends T> List<S> saveAll(Iterable<S> entities)` | Sauvegarde une liste d'entités           |
| **READ**             | `Optional<T> findById(ID id)`                         | Trouve une entité par ID                 |
|                      | `List<T> findAll()`                                   | Retourne toutes les entités              |
|                      | `List<T> findAllById(Iterable<ID> ids)`               | Trouve plusieurs entités par leurs IDs   |
|                      | `long count()`                                        | Retourne le nombre total d'entités       |
| **DELETE**           | `void deleteById(ID id)`                              | Supprime une entité par ID               |
|                      | `void delete(T entity)`                               | Supprime une entité                      |
|                      | `void deleteAllById(Iterable<? extends ID> ids)`      | Supprime plusieurs entités par leurs IDs |
|                      | `void deleteAll(Iterable<? extends T> entities)`      | Supprime plusieurs entités               |
|                      | `void deleteAll()`                                    | Supprime toutes les entités              |
| **EXISTS**           | `boolean existsById(ID id)`                           | Vérifie si une entité existe par ID      |
| **Pagination & Tri** | `List<T> findAll(Sort sort)`                          | Retourne toutes les entités triées       |
|                      | `Page<T> findAll(Pageable pageable)`                  | Retourne les entités paginées et triées  |

 */


    /*  mtd personnaliser   Vérification business : éviter doublons*/
    Optional<User> findByUsername(String username);

    boolean existsByUsername (String username);
    //boolean existsUser(User user);
}
