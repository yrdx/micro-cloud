package com.yrdx.recruit.service;

import com.yrdx.recruit.dao.RecruitDao;
import com.yrdx.recruit.pojo.Recruit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 14:17
 */
@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state){
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }

    /**
     * 最新职位列表
     * @return
     */
    public List<Recruit> newlist() {
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("0");
    }
}
