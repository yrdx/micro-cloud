package com.yrdx.gathering.service;

import com.yrdx.gathering.dao.GatheringDao;
import com.yrdx.gathering.pojo.Gathering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 16:16
 */
@Service
public class GatheringService {

    @Autowired
    private GatheringDao gatheringDao;

    /**
     * 修改
     * @param gathering
     */
    @CacheEvict(value = "gathering", key = "#gathering.id")
    public void update(Gathering gathering) {
        gatheringDao.save(gathering);
    }

    /**
     * 删除
     * @param id
     */
    @CacheEvict(value = "gathering", key = "#gathering.id")
    public void deleteById(String id) {
        gatheringDao.deleteById(id);
    }

}
