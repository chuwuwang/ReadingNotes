package com.zhou.flyweight;

/**
 * 抽象享元角色类
 * 
 * @author lee.shenzhou
 *
 */
public interface Flyweight {
	
	/**
	 *一个示意性方法,参数state是外蕴状态
	 */
	void operation(int state);
	
}