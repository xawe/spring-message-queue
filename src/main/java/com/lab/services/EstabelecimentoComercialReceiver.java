package com.lab.services;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

import com.lab.Entity.Proposta;


@Component
public class EstabelecimentoComercialReceiver {

	private CountDownLatch latch = new CountDownLatch(1);
	
	public void receiveMessage(Proposta p) throws InterruptedException {
		Thread.sleep(3000);
		Random rand = new Random();
		p.setNomeEstabelecimento("Estabelecimento " + rand.nextInt());
		p.setEc(rand.nextInt(99999999));
		System.out.println("Received << id  "+ p.getId() + " >:: Proposa " + p.getNumeroProposta() + " Ec " + p.getEc());
	}
	
	public CountDownLatch getLatch() {
		return latch;
	}
}
