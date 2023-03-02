package com.example.service.impl;

import com.example.entity.Resource;
import com.example.mapper.ResourceMapper;
import com.example.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台资源表 服务实现类
 * </p>
 *
 * @author 白木云曦
 * @since 2023-03-01
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements IResourceService {

}
