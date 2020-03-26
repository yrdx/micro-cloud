package com.yrdx.gathering.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 活动实体类
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 16:15
 */
@Entity
@Table(name="tb_gathering")
@Data
public class Gathering implements Serializable {
    @Id
    private String id;//编号
    private String name;//活动名称
    private String summary;//大会简介
    private String detail;//详细说明
    private String sponsor;//主办方
    private String image;//活动图片
    private java.util.Date starttime;//开始时间
    private java.util.Date endtime;//截止时间
    private String address;//举办地点
    private java.util.Date enrolltime;//报名截止
    private String state;//是否可见
    private String city;//城市
}
