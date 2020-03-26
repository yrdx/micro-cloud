package com.yrdx.base.dao;

import com.yrdx.base.pojo.Label;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 标签数据dao层
 * JpaSpecificationExecutor用于做复杂的条件查询
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 12:19
 */
public interface LabelDao extends JpaRepository<Label, String>,JpaSpecificationExecutor<Label> {


}
