package estacionamento;

import javax.swing.JOptionPane;

public class Operacoes {
    public String placa;
    public String cor;
    public int hora_ent;
    public int hora_sai;
    public int min_ent;
    public int min_sai;
    public double tempo;
    public double preco;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getHora_ent() {
        return hora_ent;
    }

    public void setHora_ent(int hora_ent) {
        this.hora_ent = hora_ent;
    }

    public int getHora_sai() {
        return hora_sai;
    }

    public void setHora_sai(int hora_sai) {
        this.hora_sai = hora_sai;
    }

    public int getMin_ent() {
        return min_ent;
    }

    public void setMin_ent(int min_ent) {
        this.min_ent = min_ent;
    }

    public int getMin_sai() {
        return min_sai;
    }

    public void setMin_sai(int min_sai) {
        this.min_sai = min_sai;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void calculaTempo(int hora_ent, double min_ent, int hora_sai, double min_sai){
        if (min_ent != 0 || min_sai!= 0){
            if (hora_ent<=hora_sai && min_ent<min_sai) {
                double entrada = hora_ent;
                double saida = hora_sai;
            
                this.tempo = (saida - entrada) + 1;
            }
            if (hora_ent<=hora_sai && min_ent>min_sai) {
                double entrada = hora_ent;
                double saida = hora_sai;
            
                this.tempo = (saida - entrada);
            }        
            if(hora_ent>hora_sai && min_ent<min_sai){
                double saida = (hora_sai + 24);
                double entrada = hora_ent;
            
                this.tempo = (saida - entrada) + 1;                        
            }
            if(hora_ent>hora_sai && min_ent>min_sai){
                double saida = (hora_sai + 24);
                double entrada = hora_ent;
            
                this.tempo = (saida - entrada);                        
            }
        }
        if (min_ent == min_sai) {
            if (hora_ent<=hora_sai) {
                double entrada = hora_ent;
                double saida = hora_sai;
            
                this.tempo = (saida - entrada);
            }
            if(hora_ent>hora_sai){
                double saida = (hora_sai + 24);
                double entrada = hora_ent;
            
                this.tempo = (saida - entrada);                        
            }
        }
        calculaPreco(this.tempo);
    }
    
    public void calculaPreco(double tempo){
        this.preco = tempo*4;
        
        nota();
    }
    
    public void nota(){
        JOptionPane.showMessageDialog(null, "Placa do Carro: " + getPlaca() + "\n"
                + "Cor do Carro: " + getCor() + "\n"
                + "Hoda de entrada: " + getHora_ent() + "h" + getMin_ent() + "min \n"
                + "Hoda de saída: " + getHora_sai() + "h" + getMin_sai() + "min \n"
                + "Tempo: " + getTempo() + "h \n"
                + "Preço: " + getPreco());
    }

}