package companhiaeletrica;

import javax.swing.JOptionPane;

public class CompanhiaEletrica {

    public static void main(String[] args) {
        MetodosCompanhiaEletrica dados = new MetodosCompanhiaEletrica();
        
        dados.setLeituraAnt(Integer.parseInt(JOptionPane.showInputDialog("Digite a leitura anterior")));
        dados.setLeituraAtual(Integer.parseInt(JOptionPane.showInputDialog("Digite a leitura atual")));
        
        dados.calculoGasto(dados.getLeituraAnt(), dados.getLeituraAtual());
        
    }
    
}
