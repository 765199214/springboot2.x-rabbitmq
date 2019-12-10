package cn.linkpower.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.linkpower.service.IMessageProductService;
import cn.linkpower.service.IUserService;
import cn.linkpower.service.impl.UserServiceImpl;
import cn.linkpower.vo.Usrs;

@Controller
public class TestController {
	
	private static Logger log = LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private IMessageProductService messageProductServiceImpl;
	
	@Autowired
	private IUserService userServiceImpl;
	
	@RequestMapping("/sendMsg")
	@ResponseBody
	public String sendMsg(HttpServletRequest request){
		String msg = request.getParameter("msg");
		log.info("sendMsg ---  msg--"+String.valueOf(msg));
		rabbitTemplate.convertAndSend(msg);
		return "send ok";
	}
	
	@RequestMapping("/sendMsg2")
	@ResponseBody
	public String sendMsg2(HttpServletRequest request){
		String msg = request.getParameter("msg");
		log.info("sendMsg ---  msg--"+String.valueOf(msg));
		messageProductServiceImpl.sendMessage(msg);
		return "send ok";
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUsers(){
		Usrs user = new Usrs();
		user.setUsername("xiangjiao");
		user.setPwd("123456");
		userServiceImpl.addUser(user);
		return "ok";
	}
	
	@RequestMapping("/addUser2")
	@ResponseBody
	public String addUsers2(){
		Usrs user = new Usrs();
		user.setUsername("xiangjiao2");
		user.setPwd("123456");
		userServiceImpl.addUser2(user);
		return "ok";
	}
}
