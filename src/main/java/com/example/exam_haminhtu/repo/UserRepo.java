package com.example.exam_haminhtu.repo;

import com.example.exam_haminhtu.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>, CrudRepository<UserEntity, Integer> {
    public  UserEntity findByUsername(String username);
    UserEntity findByUsernameAndPassword(String username, String password);
    UserEntity findByToken(String token);

}
