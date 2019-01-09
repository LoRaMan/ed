package cn.tuoren.ed.config;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public class Configuration {
	public static  int pageSize;

	static {
		// TODO 读取配置default.properties文件，并初始化所有配置
		pageSize = 10;
	}

}
