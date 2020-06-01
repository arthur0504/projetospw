package projetobanco;

import javax.swing.JOptionPane;

public class Banco {
    public int numConta;
    public int agencia;
    public String nome;
    private String senha;
    private double saldo;
    private boolean logado;

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }
    
    public boolean logar(int agencia, int numConta, String senha){
        if(agencia == 1234 && numConta == 1 && "123".equals(senha)){
            this.logado = true;
            atual(this.logado);            
        }else{
            JOptionPane.showMessageDialog(null, "Dados Incorretos");
            this.logado = false;
        }
        return this.logado;
    }
    
    public void sacar(double valor, boolean logado){
        if (valor > this.saldo) {
            JOptionPane.showMessageDialog(null, "Valor de saque é maior que o saldo!");
            atual(this.logado);
        }else{
            int ctz;
            ctz = Integer.parseInt(JOptionPane.showInputDialog("Você tem certeza?\n"                    
                    + "1 - Sim\n"
                    + "2 - Não"));
            switch (ctz){
                case 1:
                    this.saldo = this.saldo - valor;
                    JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$ " + getSaldo());
                    atual(this.logado);
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$ " + getSaldo());
                    atual(this.logado);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA");
                    atual(this.logado);
            }
            
            
        }
        
    }
    
    public void depositar(double valor, boolean logado){
        int ctz;
            ctz = Integer.parseInt(JOptionPane.showInputDialog("Você tem certeza?\n"                    
                    + "1 - Sim\n"
                    + "2 - Não"));
            switch (ctz){
                case 1:
                    this.saldo = this.saldo + valor;
                    JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$ " + getSaldo());
                    atual(this.logado);
                    break;
                case 2: 
                    JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$ " + getSaldo());
                    atual(this.logado);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA");
                    atual(this.logado);
            }
            
    }
    
    public void consultarSaldo(boolean logado){
        JOptionPane.showMessageDialog(null, "Seu saldo atual é de R$ " + getSaldo());
        atual(this.logado);
            
    }
    
    public void atual(boolean logado){
        if (logado == true){
            int opcao;
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Escolha o que você deseja fazer: \n"
                    + "1 - Sacar\n"
                    + "2 - Depositar\n"
                    + "3 - Consultar saldo\n"
                    + "4 - Sair"));
            
            switch(opcao){
                case 1:
                    sacar(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para saque: ")),this.logado);
                    break;
                case 2:
                    depositar(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para depósito: ")),this.logado);
                    break; 
                case 3:
                    consultarSaldo(this.logado);
                    break;    
                case 4:
                    JOptionPane.showMessageDialog(null, "Volte Sempre!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA");
                    atual(this.logado);
            }
        }
    }
    
}
