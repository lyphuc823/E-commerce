package com.lyphuc.eCommerce.user;

import com.lyphuc.eCommerce.order.Order;
import com.lyphuc.eCommerce.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "registration_date")
    @CreationTimestamp
    private LocalDateTime registrationDate;
    private boolean isEnabled;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Order> orders;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "users_roles",joinColumns =@JoinColumn(name = "user_id") ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    ///////////////////

    public UserEntity(String email, String password, String firstName, String lastName, String address, String phoneNumber, LocalDateTime registrationDate) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
    }

    public UserEntity(String email, String password, String firstName, String lastName, String address, String phoneNumber, LocalDateTime registrationDate, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.registrationDate = registrationDate;
        this.roles = roles;
    }
}
