package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.yang.domain.entity.SysLogininfor;
import top.yang.repository.BaseJdbcRepository;

/**
 * 系统访问日志情况信息 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysLogininforMapper extends BaseJdbcRepository<SysLogininfor, Long> {

  /**
   * 新增系统登录日志
   *
   * @param logininfor 访问日志对象
   */


  /**
   * 查询系统登录日志集合
   *
   * @param logininfor 访问日志对象
   * @return 登录记录集合
   */
  public List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

}
