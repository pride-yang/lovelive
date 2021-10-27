package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户与岗位关联表 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysUserPostMapper {


  /**
   * 通过岗位ID查询岗位使用数量
   *
   * @param postId 岗位ID
   * @return 结果
   */
  public int countUserPostById(Long postId);

}
