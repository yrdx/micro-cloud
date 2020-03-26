package com.yrdx.search.service;

import com.yrdx.search.dao.ArticleDao;
import com.yrdx.search.pojo.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 21:28
 */
@Service
public class ArticleSerachService {

    @Autowired
    private ArticleDao articleDao;
    /**
     * 增加文章
     * @param article
     */
    public void add(Article article) {
        articleDao.save(article);
    }

    /**
     * 根据文章搜索
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    public Page<Article> findByTitleLike(String keywords,  int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return articleDao.findByTitleOrContentLike(keywords, keywords, pageRequest);

    }
}
