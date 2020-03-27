package com.yrdx.user.dao;

import com.yrdx.user.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 10:35
 */
public interface UserDao extends JpaRepository<User,String>,JpaSpecificationExecutor<User> {
    /**
     * 根据手机号查询用户
     * @param mobile
     * @return
     */
    public User findByMobile(String mobile);
}
