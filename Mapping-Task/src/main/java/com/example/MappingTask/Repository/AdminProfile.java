package com.example.MappingTask.Repository;

import com.example.MappingTask.Entity.AdminProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminProfile extends JpaRepository<AdminProfileEntity,Long> {
    @Query(value = "select * from admin_profile where user_id = :userId",nativeQuery = true)
    AdminProfileEntity updateColumns(Long userId);
}