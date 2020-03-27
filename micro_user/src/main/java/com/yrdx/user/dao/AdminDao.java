package com.yrdx.user.dao;

import com.yrdx.user.pojo.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 管理员数据访问层
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 11:48
 */
public interface AdminDao extends JpaRepository<Admin,String>,JpaSpecificationExecutor<Admin> {
    public Admin findByLoginname(String loginname);
}
