package com.yrdx.recruit.controller;

import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;
import com.yrdx.recruit.pojo.Recruit;
import com.yrdx.recruit.service.RecruitService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 职位controller
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 14:19
 */
@RestController
@RequestMapping("/recruit")
public class RecruitController {
    @Autowired
    private RecruitService recruitService;

    /**
     * 查询推荐职位
     * @return
     */
    @RequestMapping(value="/search/recommend",method= RequestMethod.GET)
    public Result recommend(){
        List<Recruit> list = recruitService.findTop4ByStateOrderByCreatetimeDesc("2");
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    /**
     * 查询最新职位列表
     * @return
     */
    @RequestMapping(value="/search/newlist",method= RequestMethod.GET)
    public Result newlist(){
        return new Result(true,StatusCode.OK,"查询成 功",recruitService.newlist());
    }
}
