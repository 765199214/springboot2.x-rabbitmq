package cn.linkpower.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Deprecated
//@Configuration
public class MQConfig_1207 {
	
	private static Logger log = LoggerFactory.getLogger(MQConfig_1207.class);
	
	public static final String QUEUE_NAME  = "spring-boot-queue";
	
	public static final String EXCHANGE_NAME = "spring-boot-exchange";

    public static final String BINDING_KEY = "spring.boot.key.#";
    
    //创建队列
    @Bean
    public Queue queue(){
    	return new Queue(QUEUE_NAME);
    }
    
    // 创建一个 topic 类型的交换器
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);

    }

    // 使用路由键（routingKey）把队列（Queue）绑定到交换器（Exchange）
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(BINDING_KEY);

    }
}
