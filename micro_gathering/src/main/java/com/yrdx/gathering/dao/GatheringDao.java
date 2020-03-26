package com.yrdx.gathering.dao;

import com.yrdx.gathering.pojo.Gathering;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 数据访问层
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 16:16
 */
public interface GatheringDao extends JpaRepository<Gathering,String>,JpaSpecificationExecutor<Gathering>{
	
}
