package top.yang.service;

import java.util.List;
import top.yang.domain.entity.SysMenu;
import top.yang.domain.dto.SysMenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yang.manager.SysMenuManager;

/**
 * @author PrideYang
 */
@Service
public class SysMenuService {

    @Autowired
    private SysMenuManager sysMenuManager;


    public void saveOrUpdate(SysMenu sysMenu) {
        sysMenuManager.save(sysMenu);
    }

    public List<SysMenuDto> treeList() {
        return sysMenuManager.treeList();
    }
}