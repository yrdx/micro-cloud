package com.yrdx.base.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 *  标签实体类
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 12:17
 */
@Entity
@Table(name = "tb_label")
@Data
public class Label implements Serializable {
    @Id
    private String id;
    private String labelname;//标签名称
    private String state;//状态
    private Long count;//使用数量
    private Long fans;//关注数
    private String recommend;//是否推荐
}
