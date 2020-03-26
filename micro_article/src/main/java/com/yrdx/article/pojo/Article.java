package com.yrdx.article.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 文章实体
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 15:02
 */
@Entity
@Table(name="tb_article")
@Data
public class Article implements Serializable{

	@Id
	private String id;//ID

	private String columnid;//专栏ID
	private String userid;//用户ID
	private String title;//标题
	private String content;//文章正文
	private String image;//文章封面
	private java.util.Date createtime;//发表日期
	private java.util.Date updatetime;//修改日期
	private String ispublic;//是否公开
	private String istop;//是否置顶
	private Integer visits;//浏览量
	private Integer thumbup;//点赞数
	private Integer comment;//评论数
	private String state;//审核状态
	private String channelid;//所属频道
	private String url;//URL
	private String type;//类型
}
