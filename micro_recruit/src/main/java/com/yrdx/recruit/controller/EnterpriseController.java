package com.yrdx.recruit.controller;

import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;
import com.yrdx.recruit.service.EnterpriseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 招聘企业
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 14:04
 */
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 查询热门企业
     * @return
     */
    @RequestMapping(value="/search/hotlist",method=RequestMethod.GET)
    public Result hotlist(){
        return new Result(true, StatusCode.OK, "查询成功", enterpriseService.hotlist());
    }

}
