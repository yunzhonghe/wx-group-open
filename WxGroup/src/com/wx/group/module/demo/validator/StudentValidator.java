package com.wx.group.module.demo.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class StudentValidator extends Validator {

	// 在校验失败时才会调用
	@Override
	protected void handleError(Controller controller) {
		controller.keepPara("student.studentname");// 将提交的值再传回页面以便保持原先输入的值
		controller.render("/add.html");
	}

	@Override
	protected void validate(Controller controller) {
		// 验证表单域name，返回信息key,返回信息value
		validateRequiredString("student.studentname", "studentnameMsg",
				"请输入学生名称!");
	}

}