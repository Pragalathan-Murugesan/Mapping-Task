package com.example.MappingTask.Repository;

import com.example.MappingTask.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    UserEntity findOneByEmailIdIgnoreCaseAndPassword(String emailId, String password);
}
