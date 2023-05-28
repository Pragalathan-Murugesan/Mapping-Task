package com.example.MappingTask.Repository;

import com.example.MappingTask.Entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepo extends JpaRepository<AdminEntity,Long> {
@Query(value = "select * from admin_info where name = :name",nativeQuery = true)
    AdminEntity updatEmailId(String name);
}
