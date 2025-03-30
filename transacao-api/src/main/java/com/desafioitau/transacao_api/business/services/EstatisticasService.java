package com.desafioitau.transacao_api.business.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafioitau.transacao_api.controller.dtos.EstatisticasResponseDTO;
import com.desafioitau.transacao_api.controller.dtos.TransacaoRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EstatisticasService {
	
	public final TransacaoService transacaoService;
	
	public EstatisticasResponseDTO calcularEstatisticasTransacoes(Integer intervaloBusca) {
		
		log.info("Iniciada busca de estatisticas de transações");
		List<TransacaoRequestDTO> transacoes = transacaoService.buscarTransacoes(intervaloBusca);
		
		DoubleSummaryStatistics estatisticasTransacoes = transacoes.stream().mapToDouble(dto -> dto.getValor().doubleValue()).summaryStatistics();
	
		log.info("Estatisticas retornadas com sucesso");
		return new EstatisticasResponseDTO(estatisticasTransacoes.getCount(),
				estatisticasTransacoes.getSum(), estatisticasTransacoes.getAverage(),
				estatisticasTransacoes.getMin(), estatisticasTransacoes.getMax());
	}
	
	
}
