package com.wx.group.module.demo.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.wx.group.module.demo.model.Classes;


public class ClassesController extends Controller {
    public void index() {
        List<Classes> list = Classes.dao.find("select * from classes");
        setAttr("classesList", list);
        list.get(0).get("a");
        render("/index_classes.html");
    }

    public void add() {
    	System.out.println("ClassesController--add");
        render("/add_classes.html");
//        renderJson(object);
//        render(getAttr("base")+"/add_classes.html");
    }

    public void delete() {
        // 获取表单域名为studentID的值
        // Student.dao.deleteById(getPara("studentID"));
        // 获取url请求中第一个值
    	Classes.dao.deleteById(getParaToInt());
        forwardAction("/classes");
    }

    public void update() {
    	Classes model = getModel(Classes.class);
    	model.update();
        forwardAction("/classes");
    }

    public void get() {
    	Classes classes = Classes.dao.findById(getParaToInt());
        setAttr("classes", classes);
        render("/update_classes.html");
    }

    public void save() {
    	Classes model = getModel(Classes.class);
    	model.save();
        forwardAction("/classes");
    }

}