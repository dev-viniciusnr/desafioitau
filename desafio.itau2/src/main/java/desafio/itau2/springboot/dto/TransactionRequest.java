package desafio.itau2.springboot.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class TransactionRequest {

	@NotNull
	private Double valor;
	
	@NotNull
	private OffsetDateTime dataHora;

	public TransactionRequest(@NotNull @Min(0) Double valor, @NotNull OffsetDateTime dataHora) {
		this.valor = valor;
		this.dataHora = dataHora;
	}

	public Double getValor() {
		return valor;
	}

	public OffsetDateTime getDataHora() {
		return dataHora;
	}

	

}
