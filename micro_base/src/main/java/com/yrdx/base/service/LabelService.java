package com.yrdx.base.service;

import com.yrdx.base.dao.LabelDao;
import com.yrdx.base.pojo.Label;
import com.yrdx.common.util.IdWorker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 12:22
 */
@Service
public class LabelService {

    @Autowired
    private LabelDao labelDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     * @return
     */
    public List<Label> findAll() {
      return labelDao.findAll();
    }

    /**
     * 根据id查询标签
     * @param id
     * @return
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     * @param label
     */
    public void add(Label label) {
       label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 修改标签
     * @param label
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除标签
     * @param id
     */
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }
}
