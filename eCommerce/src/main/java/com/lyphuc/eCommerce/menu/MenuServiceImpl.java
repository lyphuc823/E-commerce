package com.lyphuc.eCommerce.menu;

import com.lyphuc.eCommerce.menu.MenuRepository;
import com.lyphuc.eCommerce.menu.MenuDto;
import com.lyphuc.eCommerce.menu.Menu;
import com.lyphuc.eCommerce.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.lyphuc.eCommerce.menu.MenuMapper.mapToMenu;
import static com.lyphuc.eCommerce.menu.MenuMapper.mapToMenuDto;

@Service
public class MenuServiceImpl implements MenuService {
    private MenuRepository menuRepository;
    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuDto> findAll() {
        List<Menu> menus = menuRepository.findAll();
        return getListMenuDto(menus);
    }

    private List<MenuDto> getListMenuDto(List<Menu> menus) {
        return menus.stream().map(menu -> mapToMenuDto(menu)).collect(Collectors.toList());
    }

    @Override
    public MenuDto findById(int id) {
        Optional<Menu> result = menuRepository.findById(id);
        Menu menu = null;
        if(result.isPresent()){
            menu = result.get();
        }else{
            throw new RuntimeException("Did not find menu id: "+id);
        }
        return mapToMenuDto(menu);
    }

    @Override
    public void save(MenuDto menuDto) {
        Menu menu = mapToMenu(menuDto);
        menuRepository.save(menu);
    }

    @Override
    public void deleteById(int id) {
        menuRepository.deleteById(id);
    }
}
