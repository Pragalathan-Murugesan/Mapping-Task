package com.example.MappingTask.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "admin_profile")
public class AdminProfileEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "location")
    private String location;
    @Column(name = "city")
    private String city;
    @Column(name = "user_Id")
    private Long userId;
    @OneToOne(mappedBy = "adminProfileEntity", fetch = FetchType.LAZY)
    private AdminEntity adminEntity;
}