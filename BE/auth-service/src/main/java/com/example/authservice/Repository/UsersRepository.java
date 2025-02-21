package com.example.authservice.Repository;

import com.example.authservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);

    @Query("select i.itemName from Item i join UserRole ul on i.itemId=ul.roleId " +
            "join User u on u.userId=ul.userId where u.userId =:id")
    List<String> getRoleNameByUserId(Long id);
}
