package com.wx.group.config;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.Table;
import com.jfinal.plugin.activerecord.dialect.AnsiSqlDialect;
import com.jfinal.plugin.activerecord.dialect.Dialect;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.wx.group.module.demo.controller.ClassesController;
import com.wx.group.module.demo.controller.StudentController;
import com.wx.group.module.demo.model.Classes;
import com.wx.group.module.demo.model.Student;


public class JFConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants arg0) {
//		arg0.setDevMode(true);
//		arg0.setFreeMarkerTemplateUpdateDelay(0);
	}
	@Override
	public void configHandler(Handlers arg0) {
//		arg0.add(new ContextPathHandler("base"));
	}
	@Override
	public void configInterceptor(Interceptors arg0) {
		
	}

	@Override
	public void configPlugin(Plugins arg0) {
		//FIXME 修改数据库配置和model
		C3p0Plugin cp = new C3p0Plugin("jdbc:sqlserver://localhost:1433;DatabaseName=mydb", "sa", "ljsnake");
        cp.setDriverClass("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        arg0.add(cp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
        arg0.add(arp);
        // 配置Oracle方言
//        arp.setDialect(new OracleDialect());//oracle
        arp.setDialect(new AnsiSqlDialect());//sqlserver
//        arp.setDialect(new MysqlDialect());//mysql
        // 配置属性名(字段名)大小写不敏感容器工厂
        arp.setContainerFactory(new CaseInsensitiveContainerFactory());
        
        //配置实体映射
        arp.addMapping("student", "studentid", Student.class);
        arp.addMapping("classes", "classesid", Classes.class);
        //如果没有主键或者联合主键，使用如下方式
//        arp.addMapping(tableName, modelClass)
	}
	@Override
	public void configRoute(Routes arg0) {
		arg0.add("/", ClassesController.class);
		arg0.add("/student", StudentController.class);
		arg0.add("/classes", ClassesController.class);
	}

}
