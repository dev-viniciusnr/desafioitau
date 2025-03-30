package com.desafioitau.transacao_api.business.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafioitau.transacao_api.controller.dtos.TransacaoRequestDTO;
import com.desafioitau.transacao_api.infrastructure.exceptions.UnprocessableEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransacaoService {
	
	private final List<TransacaoRequestDTO> listatransacoes = new ArrayList<>();
	
	public void adicionarTransacoes(TransacaoRequestDTO dto) {
		
		log.info("Iniciado o processamento de gravar transações");
		
		
		if(dto.getDatahora().isAfter(OffsetDateTime.now())){
			log.error("Data e hora maiores que a data atual");
			throw new UnprocessableEntity("Data e hora maiores que a data e hora atuais");
		}
		
		if(dto.getValor() < 0) {
			log.error("Valor não pode ser menor que 0");
			throw new UnprocessableEntity("Valor não pode ser menor que 0");
		}
		
		
		listatransacoes.add(dto);
		log.info("Transacoes adicionadas com sucesso");
	}
	
	public void limparTransacoes() {
		log.info("Iniciado processamento apra deletar transações");
		listatransacoes.clear();
		log.info("Transações deletadas com sucesso");
	}
	
	public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca) {
		log.info("iniciadas buscas de transações por tempo");
		OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);
		
		log.info("Retorno de transações com sucesso");
		return listatransacoes.stream().filter(x -> x.getDatahora().isAfter(dataHoraIntervalo)).toList();
		
	}
	
	
}
