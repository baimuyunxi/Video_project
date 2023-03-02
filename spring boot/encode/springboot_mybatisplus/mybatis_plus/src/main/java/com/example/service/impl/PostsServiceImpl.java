package com.example.service.impl;

import com.example.entity.Posts;
import com.example.mapper.PostsMapper;
import com.example.service.IPostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 *
 * @author 白木云曦
 * @since 2023-03-01
 */
@Service
public class PostsServiceImpl extends ServiceImpl<PostsMapper, Posts> implements IPostsService {

}
