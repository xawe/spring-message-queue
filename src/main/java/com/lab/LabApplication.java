package com.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import com.lab.services.EstabelecimentoComercialReceiver;
import com.lab.services.EquipamentoReceiver;

@SpringBootApplication
public class LabApplication {

	static final String topicExchangeName = "PropostaCadastradaExchange";
	static final String queueName = "PropostaCadastrada";
	
	
	@Bean
	Queue queue() {
		return new Queue(queueName, false);		
	}
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}
	
	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");	
	}
	
	@Bean
	  SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
	      MessageListenerAdapter listenerAdapter) {
	    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    container.setConnectionFactory(connectionFactory);
	    container.setQueueNames(queueName);
	    container.setMessageListener(listenerAdapter);
	    return container;
	  }

	  @Bean
	  MessageListenerAdapter listenerAdapter(EstabelecimentoComercialReceiver receiver) {
	    return new MessageListenerAdapter(receiver, "receiveMessage");
	  }

	public static void main(String[] args) {
		SpringApplication.run(LabApplication.class, args);
	}

}
