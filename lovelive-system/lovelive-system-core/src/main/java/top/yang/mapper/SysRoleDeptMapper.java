package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * 角色与部门关联表 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysRoleDeptMapper {

  /**
   * 查询部门使用数量
   *
   * @param deptId 部门ID
   * @return 结果
   */
  public int selectCountRoleDeptByDeptId(Long deptId);

}
