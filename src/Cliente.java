public class Cliente {

    String nome;
    long cpf;
    Computador [] computadores = new Computador[10];

    float calculaTotalCompra(){
        float total = 0;
        for (Computador computador : computadores) {
            if (computador != null) {
                total += computador.preco;
            }
        }
        return total;
    }

}
