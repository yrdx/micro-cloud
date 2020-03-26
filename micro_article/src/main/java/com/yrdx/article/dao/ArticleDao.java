package com.yrdx.article.dao;

import com.yrdx.article.pojo.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 15:02
 */
public interface ArticleDao extends JpaRepository<Article,String>,JpaSpecificationExecutor<Article> {

    /**
     * 审核
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET state = 1 WHERE id = ?", nativeQuery = true)
    public void examine(String id);

    /**
     * 点赞
     * @param id
     */
    @Modifying
    @Query(value = "UPDATE tb_article SET thumbup = thumbup+1 WHERE id = ?", nativeQuery = true)
    public void updateThumbup(String id);
}
