package com.lab.Entity;

import java.io.Serializable;

public class Proposta implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nomeEstabelecimento;
	private Integer ec;
	private String solucaoCaptura;
	private Integer numeroLogico;
	private Integer numeroProposta;
	
	
	public Integer getNumeroProposta() {
		return numeroProposta;
	}
	public void setNumeroProposta(Integer numeroProposta) {
		this.numeroProposta = numeroProposta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeEstabelecimento() {
		return nomeEstabelecimento;
	}
	public void setNomeEstabelecimento(String nomeEstabelecimento) {
		this.nomeEstabelecimento = nomeEstabelecimento;
	}
	public Integer getEc() {
		return ec;
	}
	public void setEc(Integer ec) {
		this.ec = ec;
	}
	public String getSolucaoCaptura() {
		return solucaoCaptura;
	}
	public void setSolucaoCaptura(String solucaoCaptura) {
		this.solucaoCaptura = solucaoCaptura;
	}
	public Integer getNumeroLogico() {
		return numeroLogico;
	}
	public void setNumeroLogico(Integer numeroLogico) {
		this.numeroLogico = numeroLogico;
	}
	

}
