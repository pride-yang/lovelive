package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import top.yang.domain.entity.SysDictData;
import top.yang.repository.BaseJdbcRepository;


/**
 * 字典表 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysDictDataMapper extends BaseJdbcRepository<SysDictData, Long> {

  /**
   * 根据条件分页查询字典数据
   *
   * @param dictData 字典数据信息
   * @return 字典数据集合信息
   */
  public List<SysDictData> selectDictDataList(SysDictData dictData);

  /**
   * 根据字典类型查询字典数据
   *
   * @param dictType 字典类型
   * @return 字典数据集合信息
   */
  public List<SysDictData> selectDictDataByType(String dictType);

  /**
   * 根据字典类型和字典键值查询字典数据信息
   *
   * @param dictType  字典类型
   * @param dictValue 字典键值
   * @return 字典标签
   */
  public String selectDictLabel(@Param("dictType") String dictType, @Param("dictValue") String dictValue);

  /**
   * 根据字典数据ID查询信息
   *
   * @param dictCode 字典数据ID
   * @return 字典数据
   */
  public SysDictData selectDictDataById(Long dictCode);

  /**
   * 查询字典数据
   *
   * @param dictType 字典类型
   * @return 字典数据
   */
  public int countDictDataByType(String dictType);


}
