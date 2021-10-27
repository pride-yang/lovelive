package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * 角色与菜单关联表 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysRoleMenuMapper {

  /**
   * 查询菜单使用数量
   *
   * @param menuId 菜单ID
   * @return 结果
   */
  public int checkMenuExistRole(Long menuId);

}
