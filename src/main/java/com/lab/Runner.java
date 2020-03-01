package com.lab;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lab.Entity.Proposta;
import com.lab.services.EstabelecimentoComercialReceiver;

@Component
public class Runner implements CommandLineRunner{

	 private final RabbitTemplate rabbitTemplate;
	  private final EstabelecimentoComercialReceiver receiver;

	  public Runner(EstabelecimentoComercialReceiver receiver, RabbitTemplate rabbitTemplate) {
	    this.receiver = receiver;
	    this.rabbitTemplate = rabbitTemplate;
	  }

	  @Override
	  public void run(String... args) throws Exception {
	    System.out.println("Sending message...");
	    Random rand = new Random(); 

	    for (int i = 0; i < 100; i++) {	    	
	    	Proposta p =  new Proposta();
	    	p.setNumeroProposta(rand.nextInt(999999999));
	    	p.setId(i);
	    	rabbitTemplate.convertAndSend(LabApplication.topicExchangeName, "foo.bar.baz", p);
	    	Thread.sleep(400);
		    //receiver.getLatch().await(30000, TimeUnit.MILLISECONDS);
		}
	    
	  }
	  
	  
}
