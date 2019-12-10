package cn.linkpower.service.impl;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.linkpower.config.MQConfiguration;
import cn.linkpower.service.IMessageProductService;

@Service
public class MessageProductServiceImpl implements IMessageProductService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public void sendMessage(String msg) {
		rabbitTemplate.convertAndSend(MQConfiguration.EXCHANGE,
				MQConfiguration.ROUTING_KEY,
				msg);
	}

}
