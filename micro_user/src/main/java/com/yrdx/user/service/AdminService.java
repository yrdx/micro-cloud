package com.yrdx.user.service;

import com.yrdx.common.util.IdWorker;
import com.yrdx.user.dao.AdminDao;
import com.yrdx.user.pojo.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理员service
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-27 11:45
 */
@Service
public class AdminService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private IdWorker idWorker;

    @Autowired
    private AdminDao adminDao;

    @Transactional(rollbackFor = Exception.class)
    public void add(Admin admin) {
        admin.setId( idWorker.nextId()+"" );
        //密码加密
        String encodePass = encoder.encode(admin.getPassword());
        admin.setPassword(encodePass);
        adminDao.save(admin);
    }

    /**
     * 根据登陆名和密码查询
     * @param loginname
     * @param password
     * @return
     */
    public Admin findByLoginnameAndPassword(String loginname, String password){
        Admin admin = adminDao.findByLoginname(loginname);
        if( admin!=null && encoder.matches(password,admin.getPassword())) {
            return admin;
        } else {
            return null;
        }
    }
}
