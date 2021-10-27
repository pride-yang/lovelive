package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.yang.domain.entity.GenTable;
import top.yang.domain.entity.SysConfig;
import top.yang.repository.BaseJdbcRepository;


/**
 * 参数配置 数据层
 *
 * @author ruoyi
 */@Mapper
public interface SysConfigMapper extends BaseJdbcRepository<SysConfig, Long> {

  /**
   * 查询参数配置信息
   *
   * @param config 参数配置信息
   * @return 参数配置信息
   */
  public SysConfig selectConfig(SysConfig config);

  /**
   * 查询参数配置列表
   *
   * @param config 参数配置信息
   * @return 参数配置集合
   */
  public List<SysConfig> selectConfigList(SysConfig config);

  /**
   * 根据键名查询参数配置信息
   *
   * @param configKey 参数键名
   * @return 参数配置信息
   */
  public SysConfig checkConfigKeyUnique(String configKey);

  /**
   * 新增参数配置
   *
   * @param config 参数配置信息
   * @return 结果
   */
  

}