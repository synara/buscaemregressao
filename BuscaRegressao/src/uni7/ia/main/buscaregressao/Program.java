package uni7.ia.main.buscaregressao;

import java.util.ArrayList;
import java.util.Arrays;
import uni7.ia.model.buscaregressao.*;
import uni7.ia.negocio.buscaregressao.*;

public class Program {
	public static void main(final String[] args) {

		ArrayList<String> posInicial = new ArrayList<String>(Arrays.asList("X", "2", "3", "4", "5", "1", "7", "8", "6"));
		ArrayList<String> posFinal = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "X", "7", "8"));

		Estado estadoInicial = new Estado(posInicial);
		Estado estadoFinal = new Estado(posFinal);

		Algoritmo algoritmo = new Algoritmo(estadoInicial, estadoInicial);

		algoritmo.BuscaRegressao(estadoInicial, estadoFinal);
	}

}
