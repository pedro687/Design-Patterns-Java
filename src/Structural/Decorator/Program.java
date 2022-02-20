package Structural.Decorator;

public class Program {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("rua", 11, "bairro");

        Formatador formatador = new FormataStringCaixaAlta();
        
        System.out.println(formatador.formatador(endereco));
    }
}

interface Formatador {
    String formatador(Endereco endereco);
}

class FormataStringCaixaAlta implements Formatador{
    public String formatador(Endereco endereco) {
        StringBuilder sb  = new StringBuilder();
        sb.append(endereco.getRua().toUpperCase());
        sb.append("\n");
        sb.append(endereco.getBairro().toUpperCase());
        sb.append("\n");
        sb.append(endereco.getNumero());

        return sb.toString();
    }
}

class FormataCaixaBaixa implements Formatador{
    public String formatador(Endereco endereco) {
        StringBuilder sb  = new StringBuilder();
        sb.append(endereco.getRua().toLowerCase());
        sb.append("\n");
        sb.append(endereco.getBairro().toLowerCase());
        sb.append("\n");
        sb.append(endereco.getNumero());

        return sb.toString();
    }
}

class Endereco {
    private String rua;
    private Integer numero;
    private String bairro;

    public Endereco(String rua, Integer numero, String bairro) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}