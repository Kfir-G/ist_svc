package com.ist.svc.common.util;

import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
public class IstBeanUtil {

	/**
     * 复制bean的属性
     *
     * @param source 源 要复制的对象
     * @param target 目标 复制到此对象
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target);
    }

    /**
     * 复制对象
     *
     * @param source 源 要复制的对象
     * @param target 目标 复制到此对象
     * @param <T>
     * @return
     */
    public static <T> T copy(Object source, Class<T> target) {
        if(source == null || target == null){
            return null;
        }
        try {
            T newInstance = target.newInstance();
            BeanUtils.copyProperties(source, newInstance);
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 复制list
     *
     * @param source
     * @param target
     * @param <T>
     * @param <K>
     * @return
     */
    public static <T, K> List<K> copyList(List<T> source, Class<K> target) {

        if (null == source || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().map(e -> copy(e, target)).collect(Collectors.toList());
    }
    
    /**
     *  复制list
     * @param <T>
     * @param <K>
     * @param source
     * @param target
     * @param config 自定义额外处理器
     * @return
     */
    public static <T, K> List<K> copyList(List<T> source, Class<K> target,CopyConfig<T, K> config) {

        if (null == source || source.isEmpty()) {
            return Collections.emptyList();
        }
        return source.stream().map(e -> copy(e, target,config)).collect(Collectors.toList());
    }
    
    /**
     * 复制对象
     * @param <T>
     * @param <O>
     * @param source
     * @param target
     * @param config 自定义额外处理器
     * @return
     */
    public static <T, O> T copy(O source, Class<T> target,CopyConfig<O, T> config) {
        if(source == null || target == null){
            return null;
        }
        try {
            T newInstance = target.newInstance();
            BeanUtils.copyProperties(source, newInstance);
            config.additionalProcess(source,newInstance);
            return newInstance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 
     * 复制对象时候额外处理器自定义实现
     * @param <O>
     * @param <P>
     */
    @FunctionalInterface
    public interface CopyConfig<O,P>{
		public void additionalProcess(O source, P newInstance);
    }
}
