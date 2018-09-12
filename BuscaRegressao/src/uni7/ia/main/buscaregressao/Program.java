package uni7.ia.main.buscaregressao;

import java.util.ArrayList;
import java.util.Arrays;

import uni7.ia.negocio.buscaregressao.*;

public class Program {
	public static void main(final String[] args) {
		
		ArrayList<String> posInicial = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "X"));
		ArrayList<String> posFinal = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "X", "7", "8"));

		Algoritmo algoritmo = new Algoritmo();

		algoritmo.BuscaRegressao(posInicial, posFinal);

	}

}
