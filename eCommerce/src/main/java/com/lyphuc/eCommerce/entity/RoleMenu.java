package com.lyphuc.eCommerce.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "roles_menus")
@IdClass(RoleMenuKey.class)
public class RoleMenu {
    @Id
    @Column(name = "role_id")
    private int roleId;
    @Id
    @Column(name = "menu_id")
    private int menuId;
}
