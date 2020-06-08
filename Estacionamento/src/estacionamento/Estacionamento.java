package estacionamento;

import javax.swing.JOptionPane;

public class Estacionamento {

    public static void main(String[] args) {
        Operacoes dados = new Operacoes();
        
        dados.setPlaca(JOptionPane.showInputDialog("Digite a placa do carro: "));
        dados.setCor(JOptionPane.showInputDialog("Digite a cor do carro: "));
        dados.setHora_ent(Integer.parseInt(JOptionPane.showInputDialog("Digite a hora de entrada(somente a HORA)")));
        dados.setMin_ent(Integer.parseInt(JOptionPane.showInputDialog("Digite os minutos de entrada(somente os MINUTOS)")));
        dados.setHora_sai(Integer.parseInt(JOptionPane.showInputDialog("Digite a hora de saída(somente a HORA)")));
        dados.setMin_sai(Integer.parseInt(JOptionPane.showInputDialog("Digite os minutos de saída(somente os MINUTOS)")));
        
        dados.calculaTempo(dados.getHora_ent(), dados.getMin_ent(), dados.getHora_sai(), dados.getMin_sai());
    }
    
}
