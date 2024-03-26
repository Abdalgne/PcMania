public class Computador {

    String marca;
    float preco;
    SistemaOperarional sistemaOperarional = new SistemaOperarional();
    MemoriaUSB memoriaUSB = new MemoriaUSB();
    HardwareBasico [] hardwareBasicos = new HardwareBasico[10];

    void addHardware(HardwareBasico hard, int i){
        hardwareBasicos[i] = hard;
    }


    void mostraPCConfig(){
        System.out.println("Marca: " + marca);
        System.out.println("Hardware:");
        for (HardwareBasico hardwareBasico : hardwareBasicos)
        {
            if(hardwareBasico != null)
            {
                System.out.println("    " + hardwareBasico.nome + " (" + hardwareBasico.capacidade + hardwareBasico.unidade + ")");
            }
        }
        System.out.println("Sistema Operacional: " + sistemaOperarional.nome + " (" + sistemaOperarional.tipo + " bits)");
        System.out.println("Acompanhamento: " + memoriaUSB.nome + " de " + memoriaUSB.capacidade + memoriaUSB.unidade);
        System.out.println("Preço: R$" + preco);
    }

    void addMemoriaUSB(MemoriaUSB addMemoria){
        memoriaUSB = addMemoria;
    }

}
