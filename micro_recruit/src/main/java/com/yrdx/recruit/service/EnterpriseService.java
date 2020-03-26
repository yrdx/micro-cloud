package com.yrdx.recruit.service;

import com.yrdx.recruit.dao.EnterpriseDao;
import com.yrdx.recruit.pojo.Enterprise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 招聘企业service层
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 14:02
 */
@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseDao enterpriseDao;

    /**
     * 热门企业列表
     * ishot = 1 代表热门
     * @return
     */
    public List<Enterprise> hotlist(){
        return enterpriseDao.findByIshot("1");
    }


}
