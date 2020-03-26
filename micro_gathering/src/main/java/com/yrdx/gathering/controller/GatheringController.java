package com.yrdx.gathering.controller;

import com.yrdx.common.result.Result;
import com.yrdx.common.result.StatusCode;
import com.yrdx.gathering.pojo.Gathering;
import com.yrdx.gathering.service.GatheringService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zhuls
 * @version V1.0
 * @since 2020-03-26 16:19
 */
@RestController
@RequestMapping("/gathering")
public class GatheringController {

    @Autowired
    private GatheringService gatheringService;

    /**
     * 修改
     * @param gathering
     */
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public Result update(@RequestBody Gathering gathering, @PathVariable String id ){
        gathering.setId(id);
        gatheringService.update(gathering);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public Result delete(@PathVariable String id ){
        gatheringService.deleteById(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }
}
