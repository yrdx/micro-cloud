package com.yrdx.search.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Data;

/**
 * 文章实体类
 * indexName相当于mysql的database
 * type相当于mysql的table
 * IK提供了两种分词算法：ik_smart和ik_max_word
 * 其中ik_smart为最少切分,ik_max_word为最细粒度划分
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 21:20
 */
@Document(indexName = "micro", type = "article")
@Data
public class Article implements Serializable {

    @Id
    private String id;

    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;

    @Field(index = true, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;//文章正文

    private String state;//审核状态

}
