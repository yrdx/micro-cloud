package com.yrdx.recruit.dao;

import com.yrdx.recruit.pojo.Recruit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 14:15
 */
public interface RecruitDao extends JpaRepository<Recruit,String>,JpaSpecificationExecutor<Recruit> {
    /**
     * 查询最新职位列表(按创建日期降序排序),查询前4条记录
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state);

    /**
     * 最新职位列表
     * 查询状态不为0并以创建日期降序排序，查询前12条记录
     * @param state
     * @return
     */
    public List<Recruit> findTop12ByStateNotOrderByCreatetimeDesc(String state);
}
