package top.yang.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import top.yang.domain.entity.SysMenu;
import top.yang.domain.entity.SysNotice;
import top.yang.repository.BaseJdbcRepository;


/**
 * 通知公告表 数据层
 *
 * @author ruoyi
 */
@Mapper
public interface SysNoticeMapper extends BaseJdbcRepository<SysNotice, Long> {

  /**
   * 查询公告信息
   *
   * @param noticeId 公告ID
   * @return 公告信息
   */
  public SysNotice selectNoticeById(Long noticeId);

  /**
   * 查询公告列表
   *
   * @param notice 公告信息
   * @return 公告集合
   */
  public List<SysNotice> selectNoticeList(SysNotice notice);


}