package com.lyphuc.eCommerce.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuDto {
    private int menuId;
    private String menuName;
    private String menuPid;
    private String menuPath;
}
