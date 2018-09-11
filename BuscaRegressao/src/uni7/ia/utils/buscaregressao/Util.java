package uni7.ia.utils.buscaregressao;

import java.util.ArrayList;

public class Util {
	public static void ExibirEstado(ArrayList<String> estados) {
		ArrayList<String> estadosFormatados = new ArrayList<>();
		String estado = "";
		
		for(String e: estados) {
			estado += e;
		}

		System.out.println("---------------------------------------------------------------------------------------------------");
		estadosFormatados.add(String.join("|", String.valueOf(estado.charAt(0)), String.valueOf(estado.charAt(1)), String.valueOf(estado.charAt(2))));
		estadosFormatados.add(String.join("|", String.valueOf(estado.charAt(3)), String.valueOf(estado.charAt(4)), String.valueOf(estado.charAt(5))));
		estadosFormatados.add(String.join("|", String.valueOf(estado.charAt(6)), String.valueOf(estado.charAt(7)), String.valueOf(estado.charAt(8))));

		estadosFormatados.stream().forEach(System.out::println);
	}
}
