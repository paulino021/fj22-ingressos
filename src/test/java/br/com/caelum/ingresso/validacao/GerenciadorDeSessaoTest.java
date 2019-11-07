package br.com.caelum.ingresso.validacao;

import java.time.Duration;

import org.junit.Before;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessaoTest {
	
	private Filme rogueOne;
	private Sala Sala3d;
	private Sessao sessaoDasDez;
	private Sessao sessaoDasTreze;
	private Sessao sessaoDasDezoito;
	
	@Before
	public void preparaSessoes() {
		this.rogueOne = new Filme("Rogue one", Duration.ofMinutes(120), "SCI-FI");
	}

}
