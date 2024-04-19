package com.lyphuc.eCommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRole {
    @Id
    @Column(name = "role_id")
    private int roleId;
    @Id
    @Column(name = "user_id")
    private int userId;
}
