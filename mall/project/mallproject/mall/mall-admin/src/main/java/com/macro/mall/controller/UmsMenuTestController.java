package com.macro.mall.controller;

/**
 * @author: Wsq
 * @since: 2022-04-28 11:18
 **/

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.UmsMenuNode;
import com.macro.mall.service.UmsMenuTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台菜单管理Controller
 * Created by macro on 2020/2/4.
 */
@Controller
@Api(tags = "UmsMenuTestController", description = "后台菜单管理")
@RequestMapping("/menu/test")
public class UmsMenuTestController {
    @Autowired
    UmsMenuTestService umsMenuTestService;

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> list = umsMenuTestService.treeList();
        return CommonResult.success(list);
    }

}
