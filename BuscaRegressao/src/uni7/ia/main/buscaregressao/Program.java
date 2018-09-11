package uni7.ia.main.buscaregressao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import uni7.ia.model.buscaregressao.*;
import uni7.ia.negocio.buscaregressao.*;

public class Program {
	public static void main(final String[] args) {
//1348627X5
		ArrayList<String> posInicial = new ArrayList<String>(Arrays.asList("1", "2", "X", "4", "5", "6", "7", "X", "8"));
		ArrayList<String> posFinal = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "X"));

		Algoritmo algoritmo = new Algoritmo();
		
		Estado estadoInicial = new Estado(posInicial);
		Estado estadoFinal = new Estado(posFinal);

		algoritmo.BuscaRegressao(estadoInicial, estadoFinal);

	}

}
