package com.yrdx.spit.dao;

import com.yrdx.spit.pojo.Spit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 16:44
 */
public interface SpitDao extends MongoRepository<Spit, String> {

    /**
     *  根据上级id查询吐槽列表
     * @param parentid
     * @param pageable
     * @return
     */
    public Page<Spit> findByParentid(String parentid, Pageable pageable);
}
