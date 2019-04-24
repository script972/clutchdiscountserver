package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.script972.dto.RegistrationUserDTO;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static javax.persistence.TemporalType.TIMESTAMP;

/**
 * Created by script972
 */
@Data
@Entity
@Table(name="USERS")
public class User implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "scores")
    private int score;

    @Column(name = "face_photo")
    private String facePhoto;

    @Column(name = "google_plus")
    private Boolean googlePlus;

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "enabled")
    private boolean enabled=true;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    @JsonIgnore
    @OneToMany(mappedBy = "auther")
    private Collection<CardItem> cardItem;

    @Temporal(TIMESTAMP)
    @Column(name = "birthday")
    private Date birthday;

    /**
     * Item card in access
     */
    @ManyToMany(mappedBy = "accessUsers")
    private Collection<CardItem> cardItems;

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
