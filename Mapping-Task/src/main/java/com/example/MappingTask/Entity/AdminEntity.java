package com.example.MappingTask.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "admin_info")
public class AdminEntity  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "emailId")
    private String emailId;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id", referencedColumnName = "user_Id",foreignKey = @ForeignKey(name = "user_Id"),insertable = false, updatable = false)
    private AdminProfileEntity adminProfileEntity;
}