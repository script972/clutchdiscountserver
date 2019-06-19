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
public class Authority extends BaseEntity implements GrantedAuthority {

    @JsonIgnore
    @Column(name="name")
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }


    public static final class RoleConstance {
        public static final String PREFIX = "ROLE_";

        public static final String ADMIN = PREFIX + "ADMIN";
        public static final String USER =  PREFIX + "USER";

    }

}
