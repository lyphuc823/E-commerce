package com.lyphuc.eCommerce.menu;

import com.lyphuc.eCommerce.menu.MenuDto;

import java.util.List;

public interface MenuService {
    List<MenuDto> findAll();
    MenuDto findById(int id);
    void save(MenuDto menu);
    void deleteById(int id);
}
