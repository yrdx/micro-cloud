package com.yrdx.base.service;

import com.yrdx.base.dao.LabelDao;
import com.yrdx.base.pojo.Label;
import com.yrdx.common.util.IdWorker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void add(Label label) {
       label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 修改标签
     * @param label
     */
    @Transactional
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除标签
     * @param id
     */
    @Transactional
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public List<Label> findSearch(Map searchMap){
        Specification specification= createSpecification(searchMap);
        return labelDao.findAll(specification);
    }

    /**
     * 分页条件查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    public Page<Label> findSearch(Map searchMap,int page,int size){
        Specification specification= createSpecification(searchMap);
        PageRequest pageRequest=PageRequest.of(page-1,size);
        return labelDao.findAll( specification ,pageRequest);
    }

    /**
     * 构建条件查询
     * @param searchMap
     * @return
     */
    private Specification<Label> createSpecification(Map searchMap){
        return new Specification<Label>() {

            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> query,
                CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (searchMap.get("labelname") != null && !"".equals(searchMap.get("labelname"))) {
                    predicates.add(cb.like(root.get("labelname").as(String.class), "%" + (String)searchMap.get("labelname")+"%"));
                }
                if (searchMap.get("state") != null && !"".equals(searchMap.get("state"))) {
                    predicates.add(cb.equal(root.get("state").as(String.class), (String)searchMap.get("state")));
                }
                if (searchMap.get("recommend") != null && !"".equals(searchMap.get("recommend"))) {
                    predicates.add(cb.equal(root.get("recommend").as(String.class), (String)searchMap.get("recommend")));
                }
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

}
