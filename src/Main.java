import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);

        boolean pagar = true;
        int escolha;
        
        Cliente cliente = new Cliente();

        //Add promocoes
        Computador promo1 = new Computador();
        Computador promo2 = new Computador();
        Computador promo3 = new Computador();
        HardwareBasico Pro1 = new HardwareBasico();
        HardwareBasico Pro2 = new HardwareBasico();
        HardwareBasico Pro3 = new HardwareBasico();
        HardwareBasico Men1 = new HardwareBasico();
        HardwareBasico Men2 = new HardwareBasico();
        HardwareBasico Men3 = new HardwareBasico();
        HardwareBasico Armaz1 = new HardwareBasico();
        HardwareBasico Armaz2 = new HardwareBasico();
        HardwareBasico Armaz3 = new HardwareBasico();
        MemoriaUSB usb1 = new MemoriaUSB();
        MemoriaUSB usb2 = new MemoriaUSB();
        MemoriaUSB usb3 = new MemoriaUSB();


        promo1.marca = "Positivo";
        promo1.preco = 3300;
        //add Processador
        Pro1.nome = "Pentium Core i3";
        Pro1.unidade = " Mhz";
        Pro1.capacidade = 2200;
        promo1.addHardware(Pro1, 0);
        //add memoria
        Men1.nome = "Memória RAM";
        Men1.unidade = " Gb";
        Men1.capacidade = 8;
        promo1.addHardware(Men1, 1);
        //add armazenamento
        Armaz1.nome = "HDD";
        Armaz1.unidade = " Gb";
        Armaz1.capacidade = 500;
        promo1.addHardware(Armaz1, 2);
        //add Sistema
        promo1.sistemaOperarional.nome = "Linux Ubunto";
        promo1.sistemaOperarional.tipo = 32;
        //add USB
        usb1.nome = "PenDrive";
        usb1.capacidade = 16;
        usb1.unidade = " Gb";
        promo1.addMemoriaUSB(usb1);


        promo2.marca = "Acer";
        promo2.preco = 8800;
        //add Processador
        Pro2.nome = "Pentium Core i5";
        Pro2.unidade = " Mhz";
        Pro2.capacidade = 3370;
        promo2.addHardware(Pro2, 0);
        //add memoria
        Men2.nome = "Memória RAM";
        Men2.unidade = " Gb";
        Men2.capacidade = 16;
        promo2.addHardware(Men2, 1);
        //add armazenamento
        Armaz2.nome = "HDD";
        Armaz2.unidade = " Tb";
        Armaz2.capacidade = 1;
        promo2.addHardware(Armaz2, 3);
        //add Sistema
        promo2.sistemaOperarional.nome = "Windows 8";
        promo2.sistemaOperarional.tipo = 64;
        //add USB
        usb2.nome = "PenDrive";
        usb2.capacidade = 32;
        usb2.unidade = " Gb";
        promo2.addMemoriaUSB(usb2);

        promo3.marca = "Vaio";
        promo3.preco = 4800;
        //add Processador
        Pro3.nome = "Pentium Core i7";
        Pro3.unidade = " Mhz";
        Pro3.capacidade = 4500;
        promo3.addHardware(Pro3, 0);
        //add memoria
        Men3.nome = "Memória RAM";
        Men3.unidade = " Gb";
        Men3.capacidade = 32;
        promo3.addHardware(Men3, 1);
        //add armazenamento
        Armaz3.nome = "HDD";
        Armaz3.unidade = " Tb";
        Armaz3.capacidade = 2;
        promo3.addHardware(Armaz3, 2);
        //add Sistema
        promo3.sistemaOperarional.nome = "Windows 10";
        promo3.sistemaOperarional.tipo = 64;
        //add USB
        usb3.nome = "HDD Externo";
        usb3.capacidade = 1;
        usb3.unidade = " Tb";
        promo3.addMemoriaUSB(usb3);

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
        promo3.mostraPCConfig();

        //Carrinho
        System.out.println("\n\nFavor escolher a promoção desejada (1 - 2 - 3), Caso deseje seguir para o pagamento digite 0.");
        int j = 0, limite = 0;
        while (pagar)
        {
            escolha = cin.nextInt();

            if(limite == 10)
            {
                System.out.println("Limite do carrinho atingido seuindo para o pagamento");
                    escolha = 0;
            }

            switch (escolha){
                case 1:
                    cliente.computadores[j] = promo1;
                    j++;
                    limite ++;
                    break;

                case 2:
                    cliente.computadores[j] = promo2;
                    j++;
                    limite ++;
                    break;

                case 3:
                    cliente.computadores[j] = promo3;
                    j++;
                    limite ++;
                    break;

                default:
                    if (escolha == 0){
                        if (cliente.computadores[0] == null){
                            System.out.println("Escolha ao menos uma promoção!");
                        }else{
                        System.out.println("Compra finalizada, seguindo para o pagamento.");
                        pagar = false;
                        }
                    }else{
                        System.out.println("Valor inserido Invalido, tente novamente!");
                    }
                    break;
            }
        }

        System.out.println("\n\nCarrinho final:\n    Cliente: " + cliente.nome + "\n    CPF: " + cliente.cpf);
        int k;
        for (int i = 0; i < limite; i++)
        {
            k = i + 1;
            System.out.println("\nComputador " + k);
            cliente.computadores[i].mostraPCConfig();
        }

        System.out.println("\n Totalizando em R$" + cliente.calculaTotalCompra());



    }
}