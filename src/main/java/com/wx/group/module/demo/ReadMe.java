package com.wx.group.module.demo;

public class ReadMe {
	/**
	 * S，项目重要配置在JFConfig.java中，配置db
	 * 
	 * 
	 * A，使用tomcat开发时，会有路径问题，有两种解决方案：
	 * 1、在每次调用的jsp或者重定向的action中，加上项目基础路径
	 * 2、修改tomcat的server.xml配置文件，默认指向该项目，修改方法为：
	 * 在host元素中增加以下的Context元素
	 *  <Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true"
            xmlValidation="false" xmlNamespaceAware="false">
			<Context path="" docBase="WxGroup" debug="0" reloadable="true" />
      	</Host>
      
      
      	B，关于Model字段名称问题想要人为定义的话，参照http://www.oschina.net/question/852601_153290?sort=time
      
      
	 */
}
