package uni7.ia.model.buscaregressao;

import java.util.ArrayList;

public class Estado {
	
	public ArrayList<String> posicoes;
    Estado pai;   
    
    public Estado(ArrayList<String> posicoes) {
      this.posicoes = posicoes;
    }
    
    public Estado(ArrayList<String> posicoes, Estado pai) {
      this.posicoes = posicoes;
      this.pai = pai;
    }
}
