package com.common.commonservice.Repository;

import com.common.commonservice.DTO.User.UserDetailDto;
import com.common.commonservice.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u")
    List<User> getAll();

    boolean existsByEmail(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByUserName(String userName);

    User getUserByUserName(String userName);
    User getUserByEmail(String email);
    User getUserByPhoneNumber(String phoneNumber);
    User getUserByUserId(Long id);



    @Query("SELECT new com.common.commonservice.DTO.User.UserDetailDto(u) FROM User u " +
            "WHERE (:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%')) OR :email = '') " +
            "AND (:phoneNumber IS NULL OR LOWER(u.phoneNumber) LIKE LOWER(CONCAT('%', :phoneNumber, '%')) OR :phoneNumber = '') " +
            "AND (:userName IS NULL OR LOWER(u.userName) LIKE LOWER(CONCAT('%', :userName, '%')) OR :userName = '') " +
            "AND (:name IS NULL OR LOWER(CONCAT(u.firstName, ' ', u.lastName)) LIKE LOWER(CONCAT('%', :name, '%')) OR :name = '') ")
    Page<UserDetailDto> getAllUserPaging(@Param("email") String email,
                                         @Param("phoneNumber") String phoneNumber,
                                         @Param("userName") String userName,
                                         @Param("name") String name,
                                         Pageable pageable);;
}
