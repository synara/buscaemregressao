package uni7.ia.negocio.buscaregressao;

import uni7.ia.model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.Stack;

import uni7.ia.model.buscaregressao.Estado;

public class Algoritmo {

	Estado estadoInicial;
	Estado estadoFinal;
	Stack<Estado> LE = new Stack<Estado>(); // Estados que estão sendo correntemente examinados
	Stack<Estado> LNE = new Stack<Estado>(); // Nós cujos descendentes ainda não foram examinados
	ArrayList<Estado> BSS; // Nós cujos descendentes não contem um nó objetivo
	Estado EC;// Igual ao estado adicionado mais recente ao LE
	ArrayList<Estado> filhos;

	public Algoritmo(Estado estInicial, Estado estFinal) {
		this.estadoInicial = estInicial;
		this.estadoFinal = estFinal;
		this.EC = estadoInicial;
	}

	public Optional<Stack<Estado>> BuscaRegressao(Estado estadoInicial, Estado estadoFinal) {
		LE.push(estadoInicial);
		LNE.push(estadoInicial);

		while (!LNE.isEmpty()) {
			if (EC == estadoFinal)
				return Optional.of(LE);

			filhos = gerarFilhos(EC);

			if (filhos.isEmpty()) {
				while (!LNE.empty() && EC.equals(LE.firstElement())) {
					BSS.add(EC);
					LE.pop();
					LNE.pop();
					EC = (Estado) LNE.firstElement();
				}
				LE.add(EC);
			} else {
				for (Estado e : filhos) {
					LNE.add(e);
				}
				EC = (Estado) LNE.firstElement();
				LE.add(EC);
			}
		}
		return Optional.empty(); // ver forma de retornar a falha
	}

	public ArrayList<Estado> gerarFilhos(Estado estadoAtual) {

		int indicePosicaoVazia = estadoAtual.posicoes.indexOf("X");
		ArrayList<Estado> estados = new ArrayList<Estado>();

		ArrayList<String> listaPosicoesAtuais = new ArrayList<String>(estadoAtual.posicoes);

		switch (indicePosicaoVazia) {
		case 0:
			ArrayList<String> listaPosicoesP0P1 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP0P3 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP0P1, 1);
			AddEstado(estados, estadoAtual, listaPosicoesP0P3, 3);

			break;
		case 1:
			ArrayList<String> listaPosicoesP1P0 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP1P2 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP1P4 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP1P0, 0);
			AddEstado(estados, estadoAtual, listaPosicoesP1P2, 2);
			AddEstado(estados, estadoAtual, listaPosicoesP1P4, 4);
			break;
		case 2:
			ArrayList<String> listaPosicoesP2P1 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP2P5 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP2P1, 1);
			AddEstado(estados, estadoAtual, listaPosicoesP2P5, 5);
			break;
		case 3:
			ArrayList<String> listaPosicoesP3P0 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP3P4 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP3P6 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP3P0, 0);
			AddEstado(estados, estadoAtual, listaPosicoesP3P4, 4);
			AddEstado(estados, estadoAtual, listaPosicoesP3P6, 6);
			break;
		case 4:
			ArrayList<String> listaPosicoesP4P1 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP4P3 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP4P5 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP4P7 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP4P1, 1);
			AddEstado(estados, estadoAtual, listaPosicoesP4P3, 3);
			AddEstado(estados, estadoAtual, listaPosicoesP4P5, 5);
			AddEstado(estados, estadoAtual, listaPosicoesP4P7, 7);

			break;
		case 5:
			ArrayList<String> listaPosicoesP5P2 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP5P4 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP5P8 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP5P2, 2);
			AddEstado(estados, estadoAtual, listaPosicoesP5P4, 4);
			AddEstado(estados, estadoAtual, listaPosicoesP5P8, 8);
			break;
		case 6:
			ArrayList<String> listaPosicoesP6P3 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP6P7 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP6P3, 3);
			AddEstado(estados, estadoAtual, listaPosicoesP6P7, 7);
			break;
		case 7:
			ArrayList<String> listaPosicoesP7P4 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP7P6 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP7P8 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP7P4, 4);
			AddEstado(estados, estadoAtual, listaPosicoesP7P6, 6);
			AddEstado(estados, estadoAtual, listaPosicoesP7P8, 8);

			break;
		case 8:
			ArrayList<String> listaPosicoesP8P5 = new ArrayList<String>(listaPosicoesAtuais);
			ArrayList<String> listaPosicoesP8P7 = new ArrayList<String>(listaPosicoesAtuais);
			AddEstado(estados, estadoAtual, listaPosicoesP8P5, 5);
			AddEstado(estados, estadoAtual, listaPosicoesP8P7, 7);
			break;
		default:
		}

		if (estados.isEmpty())
			BSS.add(estadoAtual);

		return estados;
	}

	public void AddEstado(ArrayList<Estado> estados, Estado estadoAtual, ArrayList<String> listaPosicoes, int position) {
		Collections.swap(listaPosicoes, estadoAtual.posicoes.indexOf("X"), position);
		Estado estado = new Estado(listaPosicoes, estadoAtual);

		if (!LNE.contains(estado) && !BSS.contains(estado))
			estados.add(estado);
	}
}
