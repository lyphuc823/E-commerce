package com.lyphuc.eCommerce.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserRoleKey implements Serializable {
    private int roleId;
    private int userId;

    public UserRoleKey(int roleId, int userId) {
        this.roleId = roleId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoleKey that = (UserRoleKey) o;
        return roleId == that.roleId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, userId);
    }
}
