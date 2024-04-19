package com.lyphuc.eCommerce.role;

import com.lyphuc.eCommerce.user.UserEntity;
import com.lyphuc.eCommerce.menu.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int roleId;
    @Column(name = "role_name")
    private String roleName;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "users_roles",joinColumns =@JoinColumn(name = "role_id") ,inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<UserEntity> users;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "roles_menus",joinColumns =@JoinColumn(name = "role_id") ,inverseJoinColumns = @JoinColumn(name = "menu_id"))
    private List<Menu> menus;

    /////////////////////

    public Role(String roleName) {
        this.roleName = roleName;
    }

}
