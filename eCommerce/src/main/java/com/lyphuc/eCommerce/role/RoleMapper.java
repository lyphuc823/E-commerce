package com.lyphuc.eCommerce.role;

import com.lyphuc.eCommerce.role.RoleDto;
import com.lyphuc.eCommerce.role.Role;

public class RoleMapper {
    public static RoleDto mapToRoleDto(Role role){
        RoleDto roleDto = RoleDto.builder()
                .roleId(role.getRoleId())
                .roleName(role.getRoleName())
                .build();
        return roleDto;
    }
    public static Role mapToRole(RoleDto roleDto){
        Role role = Role.builder()
                .roleId(roleDto.getRoleId())
                .roleName(roleDto.getRoleName())
                .build();
        return role;
    }
}
