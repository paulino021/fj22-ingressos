package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import br.com.caelum.ingresso.model.descontos.Desconto;
import br.com.caelum.ingresso.model.Sessao;;

public class Ingresso {

	private Sessao sessao;
	private BigDecimal preco;

	public Ingresso(Sessao sessao, Desconto tipoDeDesconto) {
		this.sessao = sessao;
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
	}
	

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

}
