package top.yang.manager.impl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import top.yang.component.SysMenuComponent;
import top.yang.domain.dto.SysMenuDto;
import top.yang.manager.SysMenuManager;
import top.yang.domain.entity.SysMenu;
import top.yang.domain.entity.SysMenu;
import org.springframework.stereotype.Component;

@Component
public class SysMenuManagerImpl extends BaseManagerImpl<SysMenuComponent, SysMenu, Long> implements SysMenuManager {

    @Override
    public List<SysMenuDto> treeList() {
        List<SysMenu> all = component.findAll();
        List<SysMenuDto> menuDtoList = all.stream().filter(sysMenu -> sysMenu.getParentId().equals(0L))
                .map(sysMenu -> covertMenuNode(sysMenu, all)).collect(Collectors.toList());
        return menuDtoList;
    }

    /**
     * 将SysMenu转化为SysMenuNode并设置children属性
     */
    private SysMenuDto covertMenuNode(SysMenu menu, List<SysMenu> menuList) {
        SysMenuDto node = new SysMenuDto();
        BeanUtils.copyProperties(menu, node);
        List<SysMenuDto> children = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getMenuId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());
        node.setList(children);
        return node;
    }

    @Override
    public Class getEntityClass() {
        return null;
    }
}