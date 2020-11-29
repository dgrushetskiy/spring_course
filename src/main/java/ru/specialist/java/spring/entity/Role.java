package ru.specialist.java.spring.entity;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles", schema = "microblog",
        indexes = {@Index(name = "unq_role_name", columnList = "role_name", unique = true)})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(name = "role_name", length = 100)
    private RoleName name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
