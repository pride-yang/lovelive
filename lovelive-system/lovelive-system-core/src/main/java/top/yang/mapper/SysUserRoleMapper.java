package top.yang.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色关联表 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysUserRoleMapper {

    /**
     * 通过角色ID查询角色使用数量
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int countUserRoleByRoleId(Long roleId);


}
