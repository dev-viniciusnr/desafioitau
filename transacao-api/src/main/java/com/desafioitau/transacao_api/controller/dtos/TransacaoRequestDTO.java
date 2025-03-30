package com.desafioitau.transacao_api.controller.dtos;

import java.time.OffsetDateTime;

public class TransacaoRequestDTO{

	private Double valor; 
	private OffsetDateTime datahora;
	
	public TransacaoRequestDTO(Double valor, OffsetDateTime datahora) {
		this.valor = valor;
		this.datahora = datahora;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public OffsetDateTime getDatahora() {
		return datahora;
	}

	public void setDatahora(OffsetDateTime datahora) {
		this.datahora = datahora;
	}
	
	
	
	
}
