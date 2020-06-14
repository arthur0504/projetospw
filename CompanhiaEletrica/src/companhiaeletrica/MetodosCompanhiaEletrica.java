package companhiaeletrica;

import javax.swing.JOptionPane;

public class MetodosCompanhiaEletrica {
    int leituraAnt;
    int leituraAtual;
    int difLeituras;
    double taxaTUSD;
    double taxaTE;
    double somaTaxas;
    double taxaICMS;
    String bandeira;    
    double total;


    public int getLeituraAnt() {
        return leituraAnt;
    }

    public void setLeituraAnt(int leituraAnt) {
        this.leituraAnt = leituraAnt;
    }

    public int getLeituraAtual() {
        return leituraAtual;
    }

    public void setLeituraAtual(int leituraAtual) {
        this.leituraAtual = leituraAtual;
    }

    public int getDifLeituras() {
        return difLeituras;
    }

    public void setDifLeituras(int difLeituras) {
        this.difLeituras = difLeituras;
    }

    public double getTaxaTUSD() {
        return taxaTUSD;
    }

    public void setTaxaTUSD(double taxaTUSD) {
        this.taxaTUSD = taxaTUSD;
    }

    public double getTaxaTE() {
        return taxaTE;
    }

    public void setTaxaTE(double taxaTE) {
        this.taxaTE = taxaTE;
    }

    public double getSomaTaxas() {
        return somaTaxas;
    }

    public void setSomaTaxas(double somaTaxas) {
        this.somaTaxas = somaTaxas;
    }

    public double getTaxaICMS() {
        return taxaICMS;
    }

    public void setTaxaICMS(double taxaICMS) {
        this.taxaICMS = taxaICMS;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }        
    
    public void calculoGasto(int leituraAnt, int leituraAtual){
        this.difLeituras = leituraAtual - leituraAnt;
        
        calculoTaxas(this.difLeituras);
    }
    
    public void calculoTaxas(int difLeituras){
        this.taxaTUSD = difLeituras * 0.3;
        this.taxaTE = difLeituras * 0.29;
        this.somaTaxas = this.taxaTUSD + this.taxaTE;
        this.taxaICMS = this.somaTaxas + (this.somaTaxas * 0.25);
        
        calculoBandeira(this.taxaICMS);
    }
    
    public void calculoBandeira(double taxaICMS){
        if (difLeituras <= 100) {
            this.bandeira = "Bandeira Verde";
            this.total = this.taxaICMS;
            mostraTudo();
        }
        if ((difLeituras >= 101) && (difLeituras <= 150)){
            this.bandeira = "Bandeira Amarela";
            this.total = taxaICMS + ((difLeituras * 0.013)+(difLeituras * 0.013)*0.25);
            mostraTudo();
        }
        if ((difLeituras >= 151) && (difLeituras <= 200)){
            this.bandeira = "Bandeira Vermelha - Patamar 1";
            this.total = taxaICMS + ((difLeituras * 0.042)+(difLeituras * 0.042)*0.25);
            mostraTudo();
        }
        if (difLeituras > 200){
            this.bandeira = "Bandeira Vermelha - Patamar 2";
            this.total = taxaICMS + ((difLeituras * 0.062)+(difLeituras * 0.062)*0.25);            
            mostraTudo();
        }
    }
    
    public void mostraTudo(){
        JOptionPane.showMessageDialog(null, 
                "Gasto: " + this.difLeituras + "\n"
                + "Taxas: R$ " + this.taxaICMS + "\n"
                + "Bandeira: " + this.bandeira +"\n"                          
                + "Total: R$ " + this.total);
    }
}
