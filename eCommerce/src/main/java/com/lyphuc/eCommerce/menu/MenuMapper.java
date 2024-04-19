package com.lyphuc.eCommerce.menu;

import com.lyphuc.eCommerce.menu.MenuDto;
import com.lyphuc.eCommerce.menu.Menu;

public class MenuMapper {
    public static MenuDto mapToMenuDto(Menu menu){
        MenuDto menuDto = MenuDto.builder()
                .menuId(menu.getMenuId())
                .menuPid(menu.getMenuPid())
                .menuPath(menu.getMenuPath())
                .menuName(menu.getMenuName())
                .build();
        return menuDto;
    }
    public static Menu mapToMenu(MenuDto menuDto){
        Menu menu = Menu.builder()
                .menuId(menuDto.getMenuId())
                .menuPid(menuDto.getMenuPid())
                .menuPath(menuDto.getMenuPath())
                .menuName(menuDto.getMenuName())
                .build();
        return menu;
    }
}
