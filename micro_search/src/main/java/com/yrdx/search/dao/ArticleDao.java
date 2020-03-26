package com.yrdx.search.dao;

import com.yrdx.search.pojo.Article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 21:52
 */
public interface ArticleDao extends ElasticsearchRepository<Article, String> {
    public Page<Article> findByTitleOrContentLike(String title, String content, Pageable pageable);
}
