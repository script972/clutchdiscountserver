package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by script972
 */

@Data
@Entity
@Table(name="AUTHORITY")
public class Authority implements GrantedAuthority {

    @JsonIgnore
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @Column(name="name")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

}
