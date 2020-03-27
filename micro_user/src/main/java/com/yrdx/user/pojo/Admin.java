package com.yrdx.user.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 11:45
 */
@Entity
@Table(name="tb_admin")
@Data
public class Admin implements Serializable {
    @Id
    private String id;//ID
    private String loginname;//登陆名称
    private String password;//密码
    private String state;//状态
}
