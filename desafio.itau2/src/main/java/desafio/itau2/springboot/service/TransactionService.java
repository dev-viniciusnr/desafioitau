package desafio.itau2.springboot.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import desafio.itau2.springboot.model.Transaction;

@Service
public class TransactionService {
	
	private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();
	
	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}
	
	public void clearTransaction( ) {
		transactions.clear();
	}
	
	public DoubleSummaryStatistics getStatistics() {
		OffsetDateTime now = OffsetDateTime.now();
		return transactions.stream().filter(x -> x.getDataHora().isAfter(now.minusSeconds(60))).mapToDouble(Transaction::getValor).summaryStatistics();
	}
	
}
