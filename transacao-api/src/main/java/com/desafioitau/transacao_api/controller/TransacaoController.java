package com.desafioitau.transacao_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioitau.transacao_api.business.services.TransacaoService;
import com.desafioitau.transacao_api.controller.dtos.TransacaoRequestDTO;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

	private TransacaoService transacaoService;
	
	@PostMapping
	public ResponseEntity<Void> adicionarTransacao(@RequestBody TransacaoRequestDTO dto){
		
		transacaoService.adicionarTransacoes(dto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletarTransacoes(){
		transacaoService.limparTransacoes();
		return ResponseEntity.ok().build();
	}
	
	
}
