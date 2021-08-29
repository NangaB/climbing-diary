package com.beatex.climbingDiary.repository;


import com.beatex.climbingDiary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query(value = "select username from User")
    List<String> findAllUsers();

    @Modifying
    @Query(value = "delete from User where id = :id")
    void deleteUser(Long id);
}
