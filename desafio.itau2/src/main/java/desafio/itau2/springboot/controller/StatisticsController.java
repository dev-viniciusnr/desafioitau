package desafio.itau2.springboot.controller;

import java.util.DoubleSummaryStatistics;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import desafio.itau2.springboot.dto.StatisticsResponse;
import desafio.itau2.springboot.service.TransactionService;

@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

	private final TransactionService transactionService;

	public StatisticsController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
	@GetMapping
	public ResponseEntity<StatisticsResponse> getStatistcs(){
		DoubleSummaryStatistics stats = transactionService.getStatistics();
		
		return ResponseEntity.ok(new StatisticsResponse(stats));
	}
	
	
}
