package com.yrdx.article.controller;

import com.yrdx.article.pojo.Article;
import com.yrdx.article.service.ArticleService;
import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 15:07
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 审核文章
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/examine/{articleId}", method= RequestMethod.PUT)
    public Result examine(@PathVariable String articleId){
        articleService.examine(articleId);
        return new Result(true,StatusCode.OK,"操作成功");
    }

    /**
     * 点赞文章
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/thumbup/{articleId}", method= RequestMethod.PUT)
    public Result updateThumbup(@PathVariable String articleId){
        articleService.updateThumbup(articleId);
        return new Result(true,StatusCode.OK,"操作成功");
    }

    /**
     * 根据ID查询
     * @param id ID
     * @return
     */
    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Result findById(@PathVariable String id){
        return new Result(true,StatusCode.OK,"查询成功",articleService.findById(id));
    }

    /**
     * 修改
     * @param article
     */
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public Result update(@RequestBody Article article, @PathVariable String id ){
        article.setId(id);
        articleService.update(article);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        articleService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
