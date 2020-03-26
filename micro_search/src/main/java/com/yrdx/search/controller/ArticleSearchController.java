package com.yrdx.search.controller;

import com.yrdx.common.result.PageResult;
import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;
import com.yrdx.search.pojo.Article;
import com.yrdx.search.service.ArticleSerachService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 文章搜索controller
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 21:30
 */
@RestController
@RequestMapping("/article")
public class ArticleSearchController {

    @Autowired
    private ArticleSerachService articleSerachService;

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Article article) {
        article.setState("0");
        articleSerachService.add(article);
        return new Result(true, StatusCode.OK, "操作成功");
    }

    /**
     * 分页查询文章
     * @param keywords
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{keywords}/{page}/{size}", method = RequestMethod.GET)
    public Result findByTitleLike(@PathVariable String keywords, @PathVariable int page, @PathVariable int size) {
        Page<Article> pageResult = articleSerachService.findByTitleLike(keywords, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<Article>(pageResult.getTotalElements(), pageResult.getContent()));


    }
}
