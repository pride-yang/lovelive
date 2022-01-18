package top.yang.manager;

import java.util.List;
import top.yang.domain.dto.SysMenuDto;
import top.yang.domain.entity.SysMenu;

public interface SysMenuManager extends BaseManager<SysMenu, Long> {

    List<SysMenuDto> treeList();

}