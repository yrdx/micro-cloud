package com.yrdx.qa.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * 问答中间表实体
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 14:35
 */
@Entity
@Table(name="tb_pl")
@Data
public class Pl implements Serializable {

    @Id
    private String problemid;//问题id
    @Id
    private String lableid;//回复id
}
