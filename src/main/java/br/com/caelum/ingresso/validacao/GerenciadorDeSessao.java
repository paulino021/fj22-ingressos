package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.loader.custom.Return;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {

	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDasala) {

		this.sessoesDaSala = sessoesDasala;

	}

	public boolean cabe(Sessao sessaoNova) {

		if (terminaAmanha(sessaoNova)) {
			return false;
		}
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));

	}

	private boolean terminaAmanha(Sessao sessao) {

		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaHoje(sessao);
		LocalDateTime ultimoSegundoDeHoje = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		if (terminoSessaoNova.isAfter(ultimoSegundoDeHoje)) {
			return true;
		}
		return false;

	}
	private boolean horarioIsConflitante(Sessao sessaoeExistente,Sessao sessaoNova) {
		
		LocalDateTime inicioSessaoExistente = getInicioSessaoComDiaHoje(sessaoeExistente);
		LocalDateTime terminoSessaoExistente = getTerminoSessaoComDiaHoje(sessaoeExistente);
		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaHoje(sessaoNova);
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaHoje(sessaoNova);
		
		boolean sessaoNovaTerminaAntesDaExistente = terminoSessaoNova.isBefore(inicioSessaoExistente);
		boolean sessaoNovaComecaDepoisDaExistente = terminoSessaoExistente.isBefore(inicioSessaoNova);
		
		if(sessaoNovaTerminaAntesDaExistente || sessaoNovaComecaDepoisDaExistente) {
			return false;
		}
		return true;
	}

	private LocalDateTime getInicioSessaoComDiaHoje(Sessao sessao) {
		LocalDate hoje = LocalDate.now();

		return sessao.getHorario().atDate(hoje);

	}

	private LocalDateTime getTerminoSessaoComDiaHoje(Sessao sessao) {

		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaHoje(sessao);
		return inicioSessaoNova.plus(sessao.getFilme().getDuracao());

	}
	

}
