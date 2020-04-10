package com.lab.services;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

import com.lab.Entity.Proposta;

@Component
public class EquipamentoReceiver {
	
private CountDownLatch latch = new CountDownLatch(1);
	
	public void receiveMessage(Proposta p) throws InterruptedException {
		//Thread.sleep(3000);
		Random rand = new Random();
		p.setNumeroLogico(rand.nextInt(999999));
		p.setSolucaoCaptura("LIO");
		System.out.println("Received << id  "+ p.getId() + " >:: Proposa " + p.getNumeroProposta() + " Número Logico " + p.getNumeroLogico());
	}	
	public CountDownLatch getLatch() {
		return latch;
	}
	
}
