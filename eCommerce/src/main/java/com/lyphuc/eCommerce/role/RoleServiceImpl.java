package com.lyphuc.eCommerce.role;

import com.lyphuc.eCommerce.role.RoleRepository;
import com.lyphuc.eCommerce.role.RoleDto;
import com.lyphuc.eCommerce.role.Role;
import com.lyphuc.eCommerce.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.role.RoleMapper.mapToRole;
import static com.lyphuc.eCommerce.role.RoleMapper.mapToRoleDto;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;
    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepository.findAll();
        return getRoleDtoList(roles);
    }

    private List<RoleDto> getRoleDtoList(List<Role> roles) {
        return roles.stream().map(role -> mapToRoleDto(role)).collect(Collectors.toList());
    }

    @Override
    public RoleDto findById(int id) {
        Optional<Role> result = roleRepository.findById(id);
        Role role = null;
        if(result.isPresent()){
            role = result.get();
        }else {
            throw new RuntimeException("Did not find role id: "+id);
        }
        return mapToRoleDto(role);
    }

    @Override
    public void save(RoleDto roleDto) {
        Role role = mapToRole(roleDto);
        roleRepository.save(role);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }

}
