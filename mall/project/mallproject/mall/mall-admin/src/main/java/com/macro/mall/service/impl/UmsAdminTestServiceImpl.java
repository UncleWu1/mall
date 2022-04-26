package com.macro.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.macro.mall.common.enums.UserEnum;
import com.macro.mall.common.exception.UseException;
import com.macro.mall.common.util.BeanDtoVoUtil;
import com.macro.mall.dto.UmsAdminParam;
import com.macro.mall.dto.UpdateAdminPasswordParam;
import com.macro.mall.mapper.UmsAdminMapper;
import com.macro.mall.model.UmsAdmin;
import com.macro.mall.model.UmsAdminExample;
import com.macro.mall.model.UmsResource;
import com.macro.mall.model.UmsRole;
import com.macro.mall.service.UmsAdminTestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: Wsq
 * @since: 2022-04-26 11:17
 **/
@Service
public class UmsAdminTestServiceImpl  implements UmsAdminTestService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return null;
    }

    /**
     * 注册功能
     *
     * @param umsAdminParam
     * @return
     */
    @Override
    public UmsAdmin register(UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = new UmsAdmin();
        //
//        List<UmsAdmin> umsAdmins = umsAdminMapper.selectList(new LambdaQueryWrapper<UmsAdmin>().eq(UmsAdmin::getUsername, umsAdminParam.getUsername()).eq(UmsAdmin::getStatus, 1));
//        if (umsAdmins.size() > 0) {
//            throw new UseException(UserEnum.USER_NAME_IS_EXIST);
//        }
//        List<UmsAdmin> umsAdmins1 = umsAdminMapper.selectList(new LambdaQueryWrapper<UmsAdmin>().eq(UmsAdmin::getEmail, umsAdminParam.getEmail()).eq(UmsAdmin::getStatus, 1));
//        if (umsAdmins.size() > 0) {
//            throw new UseException(UserEnum.USER_EMAIL_IS_EXIST);
//        }
        BeanUtils.copyProperties(umsAdminParam, umsAdmin);
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setStatus(1);
        umsAdmin.setPassword(passwordEncoder.encode(umsAdminParam.getPassword()));
        //判重
        //查询是否有相同用户名的用户
        UmsAdminExample example = new UmsAdminExample();
        example.createCriteria().andUsernameEqualTo(umsAdmin.getUsername());
        int insert = umsAdminMapper.insert(umsAdmin);
        if (insert >= 0) {
            return umsAdmin;
        }
        throw new UseException(UserEnum.INSERT_ADMIN_FAIL);
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public String refreshToken(String oldToken) {
        return null;
    }

    @Override
    public UmsAdmin getItem(Long id) {
        return null;
    }

    @Override
    public List<UmsAdmin> list(String keyword, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public int update(Long id, UmsAdmin admin) {
        return 0;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public int updateRole(Long adminId, List<Long> roleIds) {
        return 0;
    }

    @Override
    public List<UmsRole> getRoleList(Long adminId) {
        return null;
    }

    @Override
    public List<UmsResource> getResourceList(Long adminId) {
        return null;
    }

    @Override
    public int updatePassword(UpdateAdminPasswordParam updatePasswordParam) {
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}
