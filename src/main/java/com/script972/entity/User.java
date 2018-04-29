package com.script972.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.script972.dto.RegistrationUserDTO;
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

    @OneToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "enabled")
    private boolean enabled;

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


    public User() {
    }

    public User(String username, String password, String firstName, String lastName, String email, int score, City city,
                String phoneNumber, boolean enabled, Timestamp lastPasswordResetDate, List<Authority> authorities,
                Collection<CardItem> cardItem, Date birthday) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.score = score;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
        this.cardItem = cardItem;
        this.birthday = birthday;
    }


    public User(String username, String password, String firstName, String lastName, String email, int score,
                String facePhoto, City city, String phoneNumber, boolean enabled, Timestamp lastPasswordResetDate,
                List<Authority> authorities, Collection<CardItem> cardItem, Date birthday, Collection<CardItem> cardItems) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.score = score;
        this.facePhoto = facePhoto;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
        this.cardItem = cardItem;
        this.birthday = birthday;
        this.cardItems = cardItems;
    }

    public User(RegistrationUserDTO registrationUserDTO) {
        this.username=registrationUserDTO.getUsername();
        this.password=registrationUserDTO.getPassword();
        this.firstName=registrationUserDTO.getFirstName();
        this.lastName=registrationUserDTO.getLastName();
        this.email=registrationUserDTO.getEmail();
        this.phoneNumber=registrationUserDTO.getPhoneNumber();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Timestamp now = new Timestamp(DateTime.now().getMillis());
        this.setLastPasswordResetDate( now );
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

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

    public Collection<CardItem> getCardItem() {
        return cardItem;
    }

    public void setCardItem(Collection<CardItem> cardItem) {
        this.cardItem = cardItem;
    }


    public Collection<CardItem> getCardItems() {
        return cardItems;
    }

    public void setCardItems(Collection<CardItem> cardItems) {
        this.cardItems = cardItems;
    }

    public String getFacePhoto() {
        return facePhoto;
    }

    public void setFacePhoto(String facePhoto) {
        this.facePhoto = facePhoto;
    }

    public void setRegistrationUser(RegistrationUserDTO registrationUser) {
        this.birthday = registrationUser.getBirthday();
        this.email=registrationUser.getEmail();
        this.firstName=registrationUser.getFirstName();
        this.lastName=registrationUser.getLastName();
        this.city=registrationUser.getCity();
        this.phoneNumber=registrationUser.getPhoneNumber();
        this.facePhoto=registrationUser.getFacePhoto();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                ", city=" + city +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", enabled=" + enabled +
                ", lastPasswordResetDate=" + lastPasswordResetDate +
                ", authorities=" + authorities +
                ", birthday=" + birthday +

                '}';
    }
}
