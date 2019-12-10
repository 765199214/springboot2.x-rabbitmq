package cn.linkpower.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import cn.linkpower.config.MQConfiguration;

@Service
public class MessageConsumerService {
	
	@RabbitListener(queues=MQConfiguration.QUEUQ_NAME)
	public void receiveMessage(String msg){
		System.err.println("红色    接收消息----"+String.valueOf(msg));
	}
}
