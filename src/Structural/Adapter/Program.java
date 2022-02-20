package Structural.Adapter;

import java.math.BigDecimal;

public class Program {
    //Client
    public static void main(String[] args) {
        MeuPagamento pagamento = new MeuPagamento();
        pagamento.debitar(new BigDecimal("100"));
    }
}


//Target
interface PagamentoContrato {
    public void debitar(BigDecimal value);
    public void creditar(BigDecimal value);
}

class MeuPagamento implements PagamentoContrato{

    public static final SdkPagamento sdkPagamento = new SdkPagamento();

    //Adapta o método da sdk de pagamento dentro de meu pagamento, veja que estou adaptando o método verificar e debitar do sdk dentro 
    //do meu método debitar da classe MeuPagamento, é assim que o adaptar funciona, ele adapta fluxos.

    @Override
    public void debitar(BigDecimal value) {
        sdkPagamento.verificar(value);
        sdkPagamento.debitar(value);
        
    }

    @Override
    public void creditar(BigDecimal value) {
        sdkPagamento.creditar(value);
    }

}

//Adaptee
class SdkPagamento {

    public SdkPagamento() {

    }

    public void debitar(BigDecimal value) {
        // Debita
    }

    public void verificar(BigDecimal value) {
        // verifica
    }

    public void creditar(BigDecimal value) {
        // Credita
    }
}