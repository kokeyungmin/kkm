package com.javalec.spring_Annual.command;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_Annual.dao.ADao;
import com.javalec.spring_Annual.dto.ADto;

public class AddCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		String name=request.getParameter("name")==null?"":request.getParameter("name");
		
		ADao dao=new ADao();
		ADto dtos=dao.add(name);
		
		model.addAttribute("name",dtos);
	}

}
