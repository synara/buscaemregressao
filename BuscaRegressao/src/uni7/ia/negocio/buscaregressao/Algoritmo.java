package uni7.ia.negocio.buscaregressao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import uni7.ia.utils.buscaregressao.Util;

public class Algoritmo {

	Stack<ArrayList<String>> LE, LNE;
	ArrayList<ArrayList<String>> BSS, filhos;
	ArrayList<String> EC;
	int totalNosVisitados = 0;
	boolean sucesso;

	public Algoritmo() {
		LE = new Stack<>();
		LNE = new Stack<>();
		BSS = new ArrayList<>();
		sucesso = false;
	}

	public void BuscaRegressao(ArrayList<String> estadoInicial, ArrayList<String> estadoFinal) {
		LE.push(estadoInicial);
		LNE.push(estadoInicial);
		EC = estadoInicial;

		while (!LNE.isEmpty()) {
			totalNosVisitados++;

			if (EC.equals(estadoFinal)) {
				for (int i = 0; i < LE.size(); i++) {
					Util.ExibirEstado(LE.get(i));
				}	
				this.sucesso = true;
				System.out.println("Sucesso.");
				System.out.println("Total de nós visitados: " + totalNosVisitados);
				System.out.println("Total de nós que levam ao caminho correto: " + LE.size());				
				break;
			} else {
				filhos = gerarFilhos(EC);

				if (filhos.isEmpty()) {
					while (!LE.empty() && EC.equals(LE.peek())) {
						BSS.add(EC);
						LE.pop();
						LNE.pop();
						EC  = (!LNE.isEmpty()) ? LNE.peek() : null;
					}
					LE.add(EC);
				} else {
					for (ArrayList<String> e : filhos) {
						LNE.add(e);
					}
					EC = LNE.peek();
					LE.add(EC);
				}
			}
		}

		if (!sucesso)
			System.out.println("Falha. Objetivo não encontrado.");
	}

	public ArrayList<ArrayList<String>> gerarFilhos(ArrayList<String> estadoAtual) {

		int indicePosicaoVazia = estadoAtual.indexOf("X");
		ArrayList<ArrayList<String>> estados = new ArrayList<ArrayList<String>>();

		ArrayList<String> listaPosicoesAtuais = new ArrayList<String>(estadoAtual);

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

	public void AddEstado(ArrayList<ArrayList<String>> estados, ArrayList<String> estadoAtual, ArrayList<String> listaPosicoes,
			int position) {
		Collections.swap(listaPosicoes, estadoAtual.indexOf("X"), position);
		ArrayList<String> estado = new ArrayList<String>(listaPosicoes);

		if (!LNE.contains(estado) && !LE.contains(estado) && !BSS.contains(estado))
			estados.add(estado);
	}
}
