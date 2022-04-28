package com.macro.mall.service.impl;

import com.macro.mall.dto.UmsMenuNode;
import com.macro.mall.mapper.UmsMenuMapper;
import com.macro.mall.model.UmsMenu;
import com.macro.mall.model.UmsMenuExample;
import com.macro.mall.service.UmsMenuTestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Wsq
 * @since: 2022-04-28 11:21
 **/
@Service
public class UmsMenuTestServiceImpl implements UmsMenuTestService {
    @Autowired
    UmsMenuMapper umsMenuMapper;

    @Override
    public int create(UmsMenu umsMenu) {
        return 0;
    }

    @Override
    public int update(Long id, UmsMenu umsMenu) {
        return 0;
    }

    @Override
    public UmsMenu getItem(Long id) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        return null;
    }

    @Override
    public List<UmsMenuNode> treeList() {
        //查出所有的按钮集合
        UmsMenuExample example = new UmsMenuExample();
        List<UmsMenu> childList = umsMenuMapper.selectByExample(example);
        //先拿到每一个父级按钮
        List<UmsMenu> collect = childList.stream().filter(umsMenu -> umsMenu.getParentId() == 0L).collect(Collectors.toList());
        collect.stream().map(farther -> node(farther, childList));
        return null;
    }

    @Override
    public int updateHidden(Long id, Integer hidden) {
        return 0;
    }

    public UmsMenuNode node(UmsMenu father, List<UmsMenu> childList) {
        UmsMenuNode fatherResult = new UmsMenuNode();
        BeanUtils.copyProperties(father, fatherResult);
        List<UmsMenu> collect = childList.stream().filter(u -> u.getParentId() == father.getParentId()).collect(Collectors.toList());
        List<UmsMenuNode> collect1 = collect.stream().map(child -> node(child, childList)).collect(Collectors.toList());
        return null;
    }
}
