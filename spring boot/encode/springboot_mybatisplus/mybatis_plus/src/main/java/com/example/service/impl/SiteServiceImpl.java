package com.example.service.impl;

import com.example.entity.Site;
import com.example.mapper.SiteMapper;
import com.example.service.ISiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 站点配置 服务实现类
 * </p>
 *
 * @author 白木云曦
 * @since 2023-03-01
 */
@Service
public class SiteServiceImpl extends ServiceImpl<SiteMapper, Site> implements ISiteService {

}
