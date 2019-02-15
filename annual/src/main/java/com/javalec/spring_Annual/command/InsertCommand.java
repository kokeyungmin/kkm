package com.javalec.spring_Annual.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_Annual.dao.ADao;

public class InsertCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String id=request.getParameter("id");
		String date=request.getParameter("date");
		String coment=request.getParameter("coment");
		
		System.out.println(coment);
		
		ADao dao=new ADao();
		dao.Insert(id,coment,date); 
	}

}
