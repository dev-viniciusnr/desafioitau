package com.desafioitau.transacao_api.controller.dtos;

public class EstatisticasResponseDTO{

	private Long count;
	private Double sum;
	private Double avg;
	private Double min;
	private Double max;
	
	
	public EstatisticasResponseDTO(Long count, Double sum, Double avg, Double min, Double max) {
		this.count = count;
		this.sum = sum;
		this.avg = avg;
		this.min = min;
		this.max = max;
	}


	public Long getCount() {
		return count;
	}


	public void setCount(Long count) {
		this.count = count;
	}


	public Double getSum() {
		return sum;
	}


	public void setSum(Double sum) {
		this.sum = sum;
	}


	public Double getAvg() {
		return avg;
	}


	public void setAvg(Double avg) {
		this.avg = avg;
	}


	public Double getMin() {
		return min;
	}


	public void setMin(Double min) {
		this.min = min;
	}


	public Double getMax() {
		return max;
	}


	public void setMax(Double max) {
		this.max = max;
	}
	
	
	
	
}
