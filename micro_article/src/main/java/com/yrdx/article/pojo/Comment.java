package com.yrdx.article.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import lombok.Data;

/**
 *  评论实体类
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 19:39
 */
@Data
public class Comment implements Serializable {

    @Id
    private String _id;
    private String articleid;//文章id
    private String content;//评论内容
    private String userid;//评论人id
    private String parentid;//评论id，如果为0，表示文章的顶级评论
    private Date publishdate;//评论日期
}
