package br.com.gscapotaria.domain;

import javax.persistence.Entity;

import br.com.gscapotaria.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
private static final long serialVersionUID = 1L;
private Integer numeroDeParcelas;

	public PagamentoComCartao() {

	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super();
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
