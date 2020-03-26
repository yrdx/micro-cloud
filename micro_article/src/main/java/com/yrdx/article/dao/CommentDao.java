package com.yrdx.article.dao;

import com.yrdx.article.pojo.Comment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/*
 * 评论数据层
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 19:42
 */
public interface CommentDao extends MongoRepository<Comment, String> {

    /**
     * 根据文章id查询评论列表
     * @param articleid
     * @return
     */
    List<Comment> findByArticleid(String articleid);
}
