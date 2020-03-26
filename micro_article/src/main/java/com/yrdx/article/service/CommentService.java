package com.yrdx.article.service;

import com.yrdx.article.dao.CommentDao;
import com.yrdx.article.pojo.Comment;
import com.yrdx.common.util.IdWorker;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 19:43
 */
@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private IdWorker idWorker;

    public void add(Comment comment) {
        comment.set_id(idWorker.nextId() + "");
        comment.setPublishdate(new Date());
        commentDao.save(comment);
    }

    public List<Comment> findByArticleid(String articleid) {
        return commentDao.findByArticleid(articleid);
    }
}
