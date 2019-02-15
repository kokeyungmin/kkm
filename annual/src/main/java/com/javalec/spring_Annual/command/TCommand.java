package com.javalec.spring_Annual.command;

import org.springframework.ui.Model;

public class TCommand implements Command {

	@Override
	public void execute(Model model) {
		System.out.println("test");
	}

}
