package top.yang.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.yang.domain.dto.SysMenuDto;
import top.yang.domain.entity.SysMenu;
import top.yang.service.SysMenuService;
import top.yang.web.controller.BaseController;

/**
 * @author pride
 */
@Controller
@RequestMapping("menu")
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;


    @PostMapping("saveOrUpdate")
    @ResponseBody
    public void saveOrUpdate(SysMenu sysMenu) {
        sysMenuService.saveOrUpdate(sysMenu);
    }


    @PostMapping("treeList")
    @ResponseBody
    public List<SysMenuDto> treeList() {
        return sysMenuService.treeList();
    }
}