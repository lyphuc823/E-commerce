package com.lyphuc.eCommerce.role;

import com.lyphuc.eCommerce.role.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto findById(int id);
    void save(RoleDto roleDto);
    void deleteById(int id);
}
