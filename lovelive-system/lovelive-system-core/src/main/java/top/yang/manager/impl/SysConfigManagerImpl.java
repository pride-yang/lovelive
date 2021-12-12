package top.yang.manager.impl;

import org.springframework.stereotype.Component;
import top.yang.component.SysConfigComponent;
import top.yang.domain.entity.SysConfig;
import top.yang.manager.SysConfigManager;

/**
 * @author PrideYang
 */
@Component
public class SysConfigManagerImpl extends BaseManagerImpl<SysConfigComponent, SysConfig, Long> implements SysConfigManager {

}
