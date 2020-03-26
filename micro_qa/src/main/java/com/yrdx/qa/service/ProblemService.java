package com.yrdx.qa.service;

import com.yrdx.qa.dao.ProblemDao;
import com.yrdx.qa.pojo.Problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * 问题服务service层
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 14:42
 */
@Service
public class ProblemService {

    @Autowired
    private ProblemDao problemDao;

    /**
     * 根据标签ID查询问题列表
     * @param lableId 标签id
     * @param page
     * @param size
     * @return
     */
    public Page<Problem> findNewListByLabelId(String lableId,int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return problemDao.findNewListByLabelId(lableId,pageRequest);
    }

    /**
     * 根据标签ID查询热门问题列表
     * @param lableId
     * @param page
     * @param size
     * @return
     */
    public Page<Problem> findHotListByLabelId(String lableId,int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return problemDao.findHotListByLabelId(lableId,pageRequest);
    }

    /**
     * 根据标签ID查询等待回答列表
     * @param lableId
     * @param page
     * @param size
     * @return
     */
    public Page<Problem> findWaitListByLabelId(String lableId,int page, int size) {
        PageRequest pageRequest = PageRequest.of(page-1, size);
        return problemDao.findWaitListByLabelId(lableId,pageRequest);
    }
}
