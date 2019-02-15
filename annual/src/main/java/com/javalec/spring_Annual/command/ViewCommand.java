package com.javalec.spring_Annual.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.javalec.spring_Annual.dao.ADao;
import com.javalec.spring_Annual.dto.ADto;

public class ViewCommand implements Command {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		 
		ADao dao=new ADao();
		ArrayList<ADto> dtos=dao.view();
		/*ArrayList<ADto> dtos1=dao.log();*/
		
		model.addAttribute("view",dtos);
		/*model.addAttribute("log",dtos1);*/
	}

}
