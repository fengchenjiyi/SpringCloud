package com.yaoln.api.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import java.util.Map;
import java.util.UUID;

public class CommonUtils {
    /**
	 * 返回一个不重复去除-符号的字符串
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	/**
	 * 返回一个原始小写字符串
	 * @return
	 */
	public static String uuidLc(){
		return UUID.randomUUID().toString().toLowerCase();
	}

	/**
	 * 返回一个原始大写字符串
	 * @return
	 */
	public static String uuidUc(){
		return UUID.randomUUID().toString().toUpperCase();
	}

	/**
	 * 把map转换成对象
	 * @param map
	 * @param clazz
	 * @return
	 * 
	 * 把Map转换成指定类型
	 */
	@SuppressWarnings("rawtypes")
	public static <T> T mapToBean(Map map, Class<T> clazz) {
		try {
			/*
			 * 1. 通过参数clazz创建实例
			 * 2. 使用BeanUtils.populate把map的数据封闭到bean中
			 */
			T bean = clazz.newInstance();
			ConvertUtils.register(new DateConverter(), java.util.Date.class);
			BeanUtils.populate(bean, map);
			return bean;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 数据bean转换成Map集合
	 * @param bean
	 * @return
	 */
	public static Map beanToMap(Object bean) {
		try {
			return BeanUtils.describe(bean);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}