package com.lyphuc.eCommerce.menu;

import com.lyphuc.eCommerce.role.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "menus")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int menuId;
    @Column(name = "menu_name")
    private String menuName;
    @Column(name = "menu_pid")
    private String menuPid;
    @Column(name = "menu_path")
    private String menuPath;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "roles_menus",joinColumns =@JoinColumn(name = "menu_id") ,inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    //////////////////////////////

    public Menu(String menuName, String menuPid, String menuPath) {
        this.menuName = menuName;
        this.menuPid = menuPid;
        this.menuPath = menuPath;
    }

    ///////////////////
    public void addRole(Role role){
        if(roles == null){
            roles = new ArrayList<>();
        }
        roles.add(role);
    }
}
