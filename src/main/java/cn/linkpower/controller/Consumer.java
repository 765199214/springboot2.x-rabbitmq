package cn.linkpower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import cn.linkpower.config.MQConfig_1207;

/**
 * 消费者  监听
 * @author 765199214
 *
 */
//@Component
public class Consumer {
	
	private static Logger log = LoggerFactory.getLogger(Consumer.class);
	
	//@RabbitListener(queues=MQConfig_1207.QUEUE_NAME)
	public void consumeMessage(String msg){
		log.info("Consumer---getmsg---"+String.valueOf(msg));
	}
}
