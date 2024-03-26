import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        boolean pagar = false;
        int escolha, escolhaL;
        
        Cliente cliente = new Cliente();

        //Add promocoes
        Computador promo1 = new Computador();
        Computador promo2 = new Computador();
        Computador promo3 = new Computador();
        HardwareBasico hard = new HardwareBasico();



        promo1.marca = "Positivo";
        promo1.preco = 3300;
        //add Processador
        hard.nome = "Pentium Core i3";
        hard.unidade = " Mhz";
        hard.capacidade = 2200;
        promo1.addHardware(hard, 0);
        //add memoria
        hard.nome = "Memória RAM";
        hard.unidade = " Gb";
        hard.capacidade = 8;
        promo1.addHardware(hard, 1);
        //add armazenamento
        hard.nome = "HDD";
        hard.unidade = " Gb";
        hard.capacidade = 500;
        promo1.addHardware(hard, 2);
        //add Sistema
        promo1.sistemaOperarional.nome = "Linux Ubunto";
        promo1.sistemaOperarional.tipo = 32;


        promo2.marca = "Acer";
        promo2.preco = 8800;
        //add Processador
        hard.nome = "Pentium Core i5";
        hard.unidade = " Mhz";
        hard.capacidade = 3370;
        promo2.addHardware(hard, 0);
        //add memoria
        hard.nome = "Memória RAM";
        hard.unidade = " Gb";
        hard.capacidade = 16;
        promo2.addHardware(hard, 1);
        //add armazenamento
        hard.nome = "HDD";
        hard.unidade = " Tb";
        hard.capacidade = 1;
        promo2.addHardware(hard, 2);
        //add Sistema
        promo2.sistemaOperarional.nome = "Windows 8";
        promo2.sistemaOperarional.tipo = 64;

        promo3.marca = "Vaio";
        promo3.preco = 4800;
        //add Processador
        hard.nome = "Pentium Core i7";
        hard.unidade = " Mhz";
        hard.capacidade = 4500;
        promo3.addHardware(hard, 0);
        //add memoria
        hard.nome = "Memória RAM";
        hard.unidade = " Gb";
        hard.capacidade = 32;
        promo3.addHardware(hard, 1);
        //add armazenamento
        hard.nome = "HDD";
        hard.unidade = " Tb";
        hard.capacidade = 2;
        promo3.addHardware(hard, 2);
        //add Sistema
        promo3.sistemaOperarional.nome = "Windows 10";
        promo3.sistemaOperarional.tipo = 64;


        //Loja
        System.out.println("Bem vindo a PCMania \nPara continuarmos insira seu Nome:");
        cliente.nome = cin.next();
        System.out.println("Favor digitar seu CPF:");
        cliente.cpf = cin.nextLong();
        
        System.out.println("\nNo dia de hoje nossa loja esta com as seguintes promoções: ");

        System.out.println("\nPromoção 1:");
        promo1.mostraPCConfig();

        System.out.println("\nPromoção 2:");
        promo2.mostraPCConfig();

        System.out.println("\nPromoção 3:");
        promo2.mostraPCConfig();

        //Carrinho
        System.out.println("Favor escolher a promoção desejada (1 - 2 - 3), Caso deseje seguir para o pagamento digite 0.");
        int j = 0, limite = 0;
        while (pagar)
        {
            escolha = cin.nextInt();

            if(limite == 10)
            {
                System.out.println("Limite do carrinho atingido, favor selecionar uma promoção pra substituição (1 ao 10), ou prosseguir para o pagamento (0)");
                escolhaL = cin.nextInt();
                if(escolhaL == 0)
                    escolha = 0;
                 else {
                     j = escolhaL - 1;
                    limite--;
                }
            }

            switch (escolha){
                case 1:
                    cliente.computador[j] = promo1;
                    j++;
                    limite ++;
                    break;

                case 2:
                    cliente.computador[j] = promo1;
                    j++;
                    limite ++;
                    break;

                case 3:
                    cliente.computador[j] = promo1;
                    j++;
                    limite ++;
                    break;

                default:
                    if (escolha == 0){
                        if (cliente.computador[0] == null){
                            System.out.println("Escolha ao menos uma promoção!");
                        }else{
                        System.out.println("Compra finalizada, seguindo para o pagamento.");
                        pagar = true;
                        }
                    }else{
                        System.out.println("Valor inserido Invalido, tente novamente!");
                    }
                    break;
            }
        }

        System.out.println("Carrinho final:\n    Cliente: " + cliente.nome + "\n    CPF: " + cliente.cpf);
        for (int i = 0; i < limite; i++)
        {
            System.out.println("\nComputador " + i);
            cliente.computador[i].mostraPCConfig();
        }

        System.out.println("\n Totalizando em R$" + cliente.calculaTotalCompra());



    }
}