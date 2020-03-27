package com.yrdx.user.dao;

import com.yrdx.user.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    @Modifying
    @Query(value = "update tb_user set fanscount=fanscount+? where id=?", nativeQuery = true)
    public void updatefanscount(int x, String friendid);

    @Modifying
    @Query(value = "update tb_user set followcount=followcount+? where id=?", nativeQuery = true)
    public void updatefollowcount(int x, String userid);
}
