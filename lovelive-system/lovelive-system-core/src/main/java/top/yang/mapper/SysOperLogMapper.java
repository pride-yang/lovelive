package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.yang.domain.entity.SysOperLog;
import top.yang.repository.BaseJdbcRepository;

/**
 * 操作日志 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysOperLogMapper extends BaseJdbcRepository<SysOperLog, Long> {

  /**
   * 新增操作日志
   *
   * @param operLog 操作日志对象
   */


  /**
   * 查询系统操作日志集合
   *
   * @param operLog 操作日志对象
   * @return 操作日志集合
   */
  public List<SysOperLog> selectOperLogList(SysOperLog operLog);


  /**
   * 查询操作日志详细
   *
   * @param operId 操作ID
   * @return 操作日志对象
   */
  public SysOperLog selectOperLogById(Long operId);

}
