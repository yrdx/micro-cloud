package com.yrdx.recruit.dao;

import com.yrdx.recruit.pojo.Enterprise;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * 招聘企业实体类
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 13:58
 */

public interface EnterpriseDao extends JpaRepository<Enterprise,String>,JpaSpecificationExecutor<Enterprise> {
    public List<Enterprise> findByIshot(String ishot);
}
