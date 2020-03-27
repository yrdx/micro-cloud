package com.yrdx.qa.controller;

import com.yrdx.common.result.PageResult;
import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;
import com.yrdx.qa.client.LabelClient;
import com.yrdx.qa.pojo.Problem;
import com.yrdx.qa.service.ProblemService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 14:44
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private LabelClient labelClient;

    @RequestMapping(value="/newlist/{labelid}/{page}/{size}",method=RequestMethod.GET)
    public Result findNewListByLabelId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size ){
        Page<Problem> pageList = problemService.findNewListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<> (pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }

    /**
     * 根据标签ID查询热门问题列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value="/hotlist/{labelid}/{page}/{size}",method=RequestMethod.GET)
    public Result findHotListByLabelId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size ){
        Page<Problem> pageList = problemService.findHotListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<> (pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }

    /**
     * 根据标签ID查询等待回答列表
     * @param labelid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value="/waitlist/{labelid}/{page}/{size}",method=RequestMethod.GET)
    public Result findWaitListByLabelId(@PathVariable String labelid,@PathVariable int page,@PathVariable int size ){
        Page<Problem> pageList = problemService.findWaitListByLabelId(labelid, page, size);
        PageResult<Problem> pageResult = new PageResult<> (pageList.getTotalElements(), pageList.getContent());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }

    /**
     * 增加
     * @param problem
     */
    @RequestMapping(method=RequestMethod.POST)
    public Result add(@RequestBody Problem problem  ){
        String token = (String) request.getAttribute("claims_user");
        if(token==null || "".equals(token)){
            return new Result(false, StatusCode.ACCESSERROR, "权限不足");
        }
        problemService.add(problem);
        return new Result(true,StatusCode.OK,"增加成功");
    }

    @RequestMapping(value = "/label/{labelid}")
    public Result findLabelById(@PathVariable String labelid){
        Result result = labelClient.findById(labelid);
        return result;
    }

}
