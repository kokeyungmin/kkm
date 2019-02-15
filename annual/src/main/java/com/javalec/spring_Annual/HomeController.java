package com.javalec.spring_Annual;

import java.net.InetAddress;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.spring_Annual.command.AddCommand;
import com.javalec.spring_Annual.command.Command;
import com.javalec.spring_Annual.command.InsertCommand;
import com.javalec.spring_Annual.command.ViewCommand;
import com.javalec.spring_Annual.util.Constant;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	Command command;
	int num=0;
	
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template=this.template;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		num++;
		System.out.println("index()");
		System.out.println(num);
		
		command=new ViewCommand();
		command.execute(model);
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,Model model) {
		num++;
		System.out.println("add()");
		System.out.println(num);
		
		model.addAttribute("request",request);
		command=new AddCommand();
		command.execute(model);
		command=new ViewCommand();
		command.execute(model);
		return "index";
	}
	
	@RequestMapping("/insert")
	public String update(HttpServletRequest request,Model model) {
		num++;
		System.out.println("insert()");
		System.out.println(num);
		
		model.addAttribute("request",request);
		command=new InsertCommand();
		command.execute(model);
		return "redirect:/";
	}
	
}
