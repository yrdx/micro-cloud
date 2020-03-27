package com.yrdx.friend.dao;

import com.yrdx.friend.pojo.Friend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 15:25
 */
public interface FriendDao extends JpaRepository<Friend,String> {

    /**
     * 更新为互相喜欢
     * @param islike
     * @param userid
     * @param friendid
     */
    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid = ? AND friendid = ?", nativeQuery = true)
    public void updateIslike(String islike, String userid, String friendid);

    /**
     * 根据用户id和被关注的用户id查询记录个数
     * @param userid
     * @param friend
     * @return
     */
    @Query("select count(f) from Friend f where f.userid=?1 and f.friendid=?2")
    public int selectCount(String userid, String friend);

    /**
     * 删除好友
     * @param userid
     * @param friendid
     */
    @Modifying
    @Query(value = "delete FROM tb_friend WHERE userid = ? AND friendid = ?", nativeQuery = true)
    void deletefriend(String userid, String friendid);

}
