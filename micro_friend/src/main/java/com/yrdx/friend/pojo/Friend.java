package com.yrdx.friend.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 15:23
 */
@Entity
@Table(name = "tb_friend")
@IdClass(Friend.class)
@Data
public class Friend implements Serializable {
    @Id
    private String userid;
    @Id
    private String friendid;

    private String islike;
}
