package com.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lab.infra.PasswordEncoder;

class PasswordEncoderTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		com.lab.infra.PasswordEncoder encoder = new PasswordEncoder();
		
		String texto = "hello123";
		
		org.springframework.security.crypto.password.PasswordEncoder e = encoder.passwordEncoder(); 		
		String encodedTexto = e.encode(texto);				
		Boolean verificacaoOk = e.matches(texto, encodedTexto);				
		assertNotNull(encodedTexto);
		assertTrue(verificacaoOk);
	}
}