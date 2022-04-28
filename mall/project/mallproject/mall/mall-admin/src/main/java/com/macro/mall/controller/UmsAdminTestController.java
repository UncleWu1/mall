package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.UmsAdminLoginParam;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.service.UmsAdminTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: Wsq
 * @since: 2022-04-26 11:02
 **/
@RequestMapping("/admin/test")
@RestController
public class UmsAdminTestController {
    @Autowired
    private UmsAdminTestService umsAdminTestService;

    @RequestMapping("/register")
    public CommonResult<UmsAdmin> register(@RequestBody @Valid UmsAdminParam umsAdminParam) {
        UmsAdmin register = umsAdminTestService.register(umsAdminParam);
        if (register == null) {
            return CommonResult.failed();
        } else {
            return CommonResult.success(register);
        }
    }
    @RequestMapping("/login")
    public CommonResult<UmsAdmin> login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        String token = umsAdminTestService.login(umsAdminLoginParam.getUsername(),umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.failed();
        } else {
            return null;
        }
    }
}
