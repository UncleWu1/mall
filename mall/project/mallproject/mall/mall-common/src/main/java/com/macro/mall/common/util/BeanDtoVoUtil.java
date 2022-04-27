/*
package com.macro.mall.common.util;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

*/
/**
 *  DTO，VO，entity 转换工具类
 *
 *  @param1 oldClass 原数据--Dto，Vo，entity
 *  @param1 newClass 转换为--Dto，Vo，entity
 *  <P>
 *     1.0.0: 采用 org.springframework.beans.BeanUtils 包下的 BeanUtils.copyProperties(dtoEntity, newInstance);
 *     1.0.1: 更新为 cglib，动态生成set/get方法，提供缓存，同一组转换只动态生成一次，效率高
 *  </P>
 *//*

public class BeanDtoVoUtil {

    */
/**
     * BeanCopier的缓存
     *//*

    private static final ConcurrentHashMap<String, BeanCopier> BEAN_COPIER_CACHE = new ConcurrentHashMap<>();

    */
/**
     * dot ,do ,entity 相互转换（使用cglib）
     *
     * <P>
     *  * 1、使用 cglib, 几乎无性能损耗, 和 mapstruct 和 get/set 性能不相上下,甚至更快
     *   ---- mapstruct 在 编译时生成class文件的set,get方法，功能更全，支持属性key不一致，属性类型不一致的配置替换
     *   ---- cglib 在 BeanCopier.create动态生成set/get方法,功能单一，但性能可观,注意避免频繁 BeanCopier.create, 会重复动态生成get/set,将达不到预期的性能效果
     *
     *  2、使用 springboot的
     *   ---- BeanUtils.copyProperties(oldClass, newInstance);
     *
     *  3、使用 mapstruct
     *   ---- 参考 AdminAuthorityConverter 转换类,启动项目会动态生成 AdminAuthorityConverterImpl的calss类，并生成转换方法
     * </P>
     * @param oldClass  原数据--Dto，Vo，entity
     * @param newClass  转换为--Dto，Vo，entity
     * @version 1.0.0
     *//*

    public static <E> E convert(Object oldClass, Class<E> newClass) {
        if (oldClass == null) {
            return null;
        }
        if (newClass == null) {
            return null;
        }
        E newInstance = null;
        try {
            newInstance = newClass.newInstance();
        } catch (Exception e) {
            return null;
        }
        String key = oldClass.getClass().getName() + ":" + newClass.getName();
        BeanCopier copier = null;
        if (BEAN_COPIER_CACHE.containsKey(key)) {
            copier = BEAN_COPIER_CACHE.get(key);
        } else {
            copier = BeanCopier.create(oldClass.getClass(), newInstance.getClass(), false);
            BEAN_COPIER_CACHE.put(key, copier);
        }
        copier.copy(oldClass, newInstance, null);
        return newInstance;
    }


    */
/**
     * Page<Entity> 分页对象转 Page<Vo>  ( list 循环)
     * @version 1.0.0
     *//*

    public static <T, V> IPage<V> pageVo(Page<T> page, Class<V> v) {
        if (page == null) {
            return null;
        }
        return page.convert(item -> BeanDtoVoUtil.convert(item, v));
    }


    */
/**
     * list<Entity> 集合对象转list<Vo> ( list 循环)
     * @version 1.0.0
     *//*

    public static <T, V> List<V> listVo(List<T> oldList, Class<V> v) {
        List<V> voList = new ArrayList<>();
        if (oldList != null) {
            oldList.forEach(i -> voList.add(BeanDtoVoUtil.convert(i, v)));
        }
        return voList;
    }


    */
/**
     * list<Entity> 集合对象转list<Vo> （parallelStream 并行流方式，适合大量数据下使用）
     * @version 1.0.0
     *//*

    public static <T, V> List<V> listVoStream(List<T> oldList, Class<V> v) {
        if (oldList == null || oldList.isEmpty()) {
            return new ArrayList<>();
        }
        return oldList.parallelStream().map(item -> (V) BeanDtoVoUtil.convert(item, v)).collect(Collectors.toList());
    }
}
*/
