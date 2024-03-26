public class Cliente {

    String nome;
    long cpf;
    Computador [] computador = new Computador[10];

    float calculaTotalCompra(){
        float total = 0;
        for (int i = 0; computador[i] != null; i++)
            total += computador[i].preco;
        return total;
    }

}
