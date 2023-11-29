package model;
import java.util.*;

public class Cartao{

    private double saldoCartao;
    private double limiteCartao;
    private List<String> listaCompras = new ArrayList<>();
    private String tipoCompra;
    private double valorCompra;

    public Cartao(double limiteCartao){
        this.saldoCartao = limiteCartao;
        this.limiteCartao = limiteCartao;
    }

    public Cartao (){

    }

    public double getSaldoCartao() {
        return saldoCartao;
    }

    public double getLimiteCartao() {
        return limiteCartao;
    }

    public List<String> getListaCompras() {
        return listaCompras;
    }

    public String getTipoCompra() {
        return tipoCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setSaldoCartao(double saldoCartao) {
        this.saldoCartao = saldoCartao;
    }

    public double setValorCompra(double valorCompra){
        this.valorCompra = valorCompra;
        return valorCompra;
    }

    public void setTipoCompra(String tipoCompra) {
        this.tipoCompra = tipoCompra;
    }

    public double calculaSaldo() {
        double novoSaldo = this.getLimiteCartao();

        // Subtrai o valor de cada compra do saldo
        for (String compra : this.getListaCompras()) {
            String[] partes = compra.split(": R\\$"); // Divide a string para obter o valor da compra
            double valorCompra = Double.parseDouble(partes[1].trim());
            novoSaldo -= valorCompra;
        }

        return novoSaldo;
    }


    public void adicionarCompra(String tipoCompra, double valorCompra) {
        if (valorCompra <= saldoCartao) {
            saldoCartao -= valorCompra;
            listaCompras.add(tipoCompra + ": R$" + valorCompra);
        }
    }
}
