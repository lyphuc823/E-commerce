package com.lyphuc.eCommerce.entity;

import java.io.Serializable;
import java.util.Objects;

public class RoleMenuKey implements Serializable {
    private int roleId;
    private int menuId;

    public RoleMenuKey(int roleId, int menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleMenuKey that = (RoleMenuKey) o;
        return roleId == that.roleId && menuId == that.menuId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, menuId);
    }
}
