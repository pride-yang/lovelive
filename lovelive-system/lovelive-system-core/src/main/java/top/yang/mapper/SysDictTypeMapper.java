package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.yang.domain.entity.SysDictType;
import top.yang.repository.BaseJdbcRepository;

/**
 * 字典表 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysDictTypeMapper extends BaseJdbcRepository<SysDictType, Long> {

  /**
   * 根据条件分页查询字典类型
   *
   * @param dictType 字典类型信息
   * @return 字典类型集合信息
   */
  public List<SysDictType> selectDictTypeList(SysDictType dictType);

  /**
   * 根据所有字典类型
   *
   * @return 字典类型集合信息
   */
  public List<SysDictType> selectDictTypeAll();

  /**
   * 根据字典类型ID查询信息
   *
   * @param dictId 字典类型ID
   * @return 字典类型
   */
  public SysDictType selectDictTypeById(Long dictId);

  /**
   * 根据字典类型查询信息
   *
   * @param dictType 字典类型
   * @return 字典类型
   */
  public SysDictType selectDictTypeByType(String dictType);


  /**
   * 修改字典类型信息
   *
   * @param dictType 字典类型信息
   * @return 结果
   */
  public int updateDictType(SysDictType dictType);

  /**
   * 校验字典类型称是否唯一
   *
   * @param dictType 字典类型
   * @return 结果
   */
  public SysDictType checkDictTypeUnique(String dictType);
}
