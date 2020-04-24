package org.example;
// Diego Garcia Buriola - TIA - 31952917
// Rodrigo Queiroz de Francischi - TIA - 31948596
// Victor Hugo Pinheiro Garcia - TIA - 31917658

import org.example.entidades.Aplicativo;
import org.example.entidades.Computador;
import org.example.entidades.Pais;
import org.example.persistencia.AplicativoDAO;
import org.example.persistencia.ComputadorDAO;
import org.example.persistencia.PaisDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    PaisDAO dao;
    ComputadorDAO daoo;
    AplicativoDAO daao;
    Scanner in;

    public InterfaceUsuario(PaisDAO dao, ComputadorDAO daoo, AplicativoDAO daao) {
        this.dao = dao;
        this.daoo = daoo;
        this.daao = daao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc;
        int op;

        do {
            System.out.println("\n* Escolha em qual tabela deseja fazer as alterações *");
            System.out.println("\t1. Pais");
            System.out.println("\t2. Computador");
            System.out.println("\t3. Aplicativo");
            System.out.println("\t4. Sair");
            System.out.print("\nEscolha uma opção: ");
            opc = in.nextInt();

            while(opc < 1 || opc > 4){
                System.out.println("Opção inválida, digite novamente: ");
                System.out.println("\t1. Pais");
                System.out.println("\t2. Computador");
                System.out.println("\t3. Aplicativo");
                System.out.println("\t4. Sair");
                System.out.print("\nEscolha uma opção: ");
                opc = in.nextInt();
            }

            switch (opc) {
                case 1:
                    System.out.println("\n*Tabela pais escolhida*");
                    System.out.println("\nEscolha a opção do menu:");
                    System.out.println("\t1. Create - Adicionar um pais à tabela");
                    System.out.println("\t2. Read - Ler os dados atuais da tabela");
                    System.out.println("\t3. Update - Atualizar os dados da tabela");
                    System.out.println("\t4. Delete - Deletar um pais da tabela");
                    System.out.println("\t5. Sair - Voltar para  o menu principal");

                    op= in.nextInt();

                    if(op==1){
                        this.createpais();
                    }
                    else if (op==2){
                        this.readpais();
                    }
                    else if (op==3){
                        this.updatepais();
                    }
                    else if (op==4){
                        this.deletepais();
                    }
                    else {
                        imprimirMenu();
                    }
                    break;

                case 2:
                    System.out.println("\n*Tabela computador escolhida*\n");
                    System.out.println("Escolha a opção do menu:");
                    System.out.println("\t1. Create - Adicionar um computador à tabela");
                    System.out.println("\t2. Read - Ler os dados atuais da tabela");
                    System.out.println("\t3. Update - Atualizar os dados da tabela");
                    System.out.println("\t4. Delete - Deletar um pais da tabela");
                    System.out.println("\t5. Sair - Voltar para  o menu principal");

                    op= in.nextInt();

                    if(op==1){
                        this.createcomputador();
                    }
                    else if(op==2){
                        this.readcomputador();
                    }
                    else if(op==3){
                        this.updatecomputador();
                    }
                    else if (op==4) {
                        this.deletecomputador();
                    }
                    else{
                        imprimirMenu();
                    }
                    break;
                case 3:
                    System.out.println("\nTabela aplicativo escolhida:\n");
                    System.out.println("Escolha a opção do menu:");
                    System.out.println("\t1. Create - Adicionar um aplicativo à tabela");
                    System.out.println("\t2. Read - Ler os dados atuais da tabela");
                    System.out.println("\t3. Update - Atualizar os dados da tabela");
                    System.out.println("\t4. Delete - Deletar um aplicativo da tabela");
                    System.out.println("\t5. Sair - Voltar para  o menu principal");

                    op= in.nextInt();

                    if(op==1){
                        this.createaplicativo();
                    }
                    else if (op==2){
                        this.readaplicativo();
                    }
                    else if (op==3){
                        this.updateaplicativo();
                    }
                    else if (op==4){
                        this.deleteaplicativo();
                    }
                    else {
                        imprimirMenu();
                    }
                case 4:
                    System.out.println("Saindo...");
                    break;
            }
        } while (opc != 4);
    }

    private void createpais(){
        Pais paises = new Pais();

        System.out.println("*** Novo pais ***");
        System.out.print("\nInforme o nome do pais: ");
        paises.setNome(in.nextLine());

        System.out.print("Informe a populacao do pais: ");
        paises.setPopulacao(in.nextLong());

        System.out.print("Informe o continente em que o pais esta localizado: " +
                "\n1- América do Sul" +
                "\n2- América do Norte/Central" +
                "\n3- Europa" +
                "\n4- Ásia" +
                "\n5- Oceania\n");
        paises.setContinente(in.nextInt());

        if (dao.createpais(paises)) {
            System.out.println("Pais adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o país :(");
        }
    }

    private void readpais(){
        List<Pais> paises = dao.readpais();

        System.out.println("\n************************************");
        System.out.println("*** Lista dos paises cadastrados ***");
        System.out.println("************************************\n");
        for (Pais pais : paises) {
            System.out.println(pais);
        }
    }

    private void updatepais(){
        Pais paises = new Pais();

        System.out.println("*** Atualizar um País ***");

        System.out.println("Insira o ID do país que deseja alterar:");
        paises.setId(in.nextInt());
        in.nextLine();

        System.out.println("Altere o nome do país para...:");
        paises.setNome(in.nextLine());

        System.out.println("Altere o continente do país para...:");
        paises.setContinente(in.nextInt());

        System.out.println("Altere a população do país para...:");
        paises.setPopulacao(in.nextLong());


        if (dao.updatepais(paises)) {
            System.out.println("Pais atualizado no banco de Dados");
        } else {
            System.out.println("Ops: problema ao atualizar o país :(");
        }

    }

    private void deletepais(){
        List<Pais> paises = dao.readpais();

        while (true) {
            System.out.println("\n************************************");
            System.out.println("*** Lista dos paises cadastrados ***");
            System.out.println("************************************\n");
            int i = 0;
            for (Pais pais : paises) {
                System.out.println(i + " - " + pais);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual pais deseja remover?\n");
            int opc = in.nextInt();
            //Necessário para ler a quebra de linha (enter)
            in.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= paises.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.deletepais(paises.get(opc))) {
                    System.out.println("Falha ao tentar remover");
                } else {
                    System.out.println("Pais " + paises.get(opc).getNome() +
                            " removido com sucesso");
                }
                //Isso para o while infinito
                break;
            }
            for (Pais pais : paises) {
                System.out.println(pais);
            }
        }
    }

    private void createaplicativo(){
        Aplicativo app = new Aplicativo();

        System.out.println("*** Novo aplicativo***");

        System.out.print("\nInforme o nome do aplicativo: ");
        app.setNome(in.nextLine());

        System.out.print("Informe o desenvolvedor do aplicativo: ");
        app.setDesenvolvedor(in.nextLine());

        System.out.print("Informe o numero de downloads do aplicativo: ");
        app.setNrm_downloads(in.nextInt());

        if (daao.createaplicativo(app)) {
            System.out.println("\nAplicativo adicionado ao banco de Dados\n");
        } else {
            System.out.println("\nOps: problema ao adicionar o aplicativo :(");
        }

    }
    private void readaplicativo(){
        List<Aplicativo> aplicativos = daao.readaplicativo();

        System.out.println("\n*****************************************");
        System.out.println("*** Lista dos aplicativos cadastrados ***");
        System.out.println("*****************************************\n");
        for (Aplicativo aplicativo : aplicativos ) {
            System.out.println(aplicativo);
        }
    }

    private void updateaplicativo(){
        Aplicativo app = new Aplicativo();

        System.out.println("*** Atualizar um Aplicativo ***");

        System.out.println("Insira o ID do aplicativo que deseja alterar:");
        app.setId(in.nextInt());
        in.nextLine();

        System.out.println("Altere o nome do aplicativo:");
        app.setNome(in.nextLine());

        System.out.println("Altere o desenvolvedor do aplicativo:");
        app.setDesenvolvedor(in.nextLine());

        System.out.println("Altere o numero de downloads:");
        app.setNrm_downloads(in.nextInt());

        if (daao.updateaplicativo(app)) {
            System.out.println("Aplicativo atualizado no banco de Dados");
        } else {
            System.out.println("Ops: problema ao atualizar o aplicativo :(");
        }

    }



    private void deleteaplicativo(){
        List<Aplicativo> aplicativos = daao.readaplicativo();

        while (true) {
            System.out.println("\n*****************************************");
            System.out.println("*** Lista dos aplicativos cadastrados ***");
            System.out.println("*****************************************\n");
            int i = 0;
            for (Aplicativo aplicativo : aplicativos) {
                System.out.println(i + " - " + aplicativo);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual aplicativo deseja remover?\n");
            int opc = in.nextInt();
            //Necessário para ler a quebra de linha (enter)
            in.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= aplicativos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (daao.deleteaplicativo(aplicativos.get(opc))) {
                    System.out.println("Ops, falha ao remover");
                } else {
                    System.out.println("Aplicativo " + aplicativos.get(opc).getNome() +
                            " removido com sucesso");
                }
                //Isso para o while infinito
                break;
            }
            for (Aplicativo aplicativo : aplicativos) {
                System.out.println(aplicativo);
            }
        }

    }
    private void createcomputador(){
        Computador comp = new Computador();

        System.out.println("*** Novo Computador***");

        System.out.print("\nInforme a marca do computador: ");
        comp.setMarca(in.nextLine());

        System.out.print("Informe o processador do computador: ");
        comp.setProcessador(in.nextLine());

        System.out.print("Informe a quantidade de ram do computador: ");
        comp.setQnt_ram(in.nextInt());

        System.out.print("Informe o tamanho do disco do computador: ");
        comp.setTamanho_disco(in.nextInt());


        if (daoo.createcomputador(comp)) {
            System.out.println("Computador adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o computador :(");
        }

    }
    private void readcomputador(){
        List<Computador> computadores = daoo.readcomputador();

        System.out.println("\n******************************************");
        System.out.println("*** Lista dos computadores cadastrados ***");
        System.out.println("******************************************\n");
        for (Computador computador : computadores ) {
            System.out.println(computador);
        }
    }
    private void updatecomputador(){
        Computador comp = new Computador();

        System.out.println("*** Atualizar um computador ***");

        System.out.println("Insira o ID do computador que deseja alterar:");
        comp.setId(in.nextInt());
        in.nextLine();

        System.out.println("Altere o marca do computador:");
        comp.setMarca(in.nextLine());

        System.out.println("Altere o processador do computador:");
        comp.setProcessador(in.nextLine());

        System.out.println("Altere a qnt de ram:");
        comp.setQnt_ram(in.nextInt());

        System.out.println("Altere o tamanho do disco:");
        comp.setTamanho_disco(in.nextInt());

        if (daoo.updatecomputador(comp)) {
            System.out.println("Computador atualizado no banco de Dados");
        } else {
            System.out.println("Ops: problema ao atualizar o computador :(");
        }
    }
    private void deletecomputador(){
        List<Computador> computadores = daoo.readcomputador();

        while (true) {
            System.out.println("\n******************************************");
            System.out.println("*** Lista dos computadores cadastrados ***");
            System.out.println("******************************************\n");
            int i = 0;
            for (Computador computador : computadores) {
                System.out.println(i + " - " + computador);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual Computador deseja remover?\n");
            int opc = in.nextInt();
            //Necessário para ler a quebra de linha (enter)
            in.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= computadores.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (daoo.deletecomputador(computadores.get(opc))) {
                    System.out.println("Falha ao remover");
                } else {
                    System.out.println("Computador " + computadores.get(opc).getMarca() +
                            " removido com sucesso");
                }
                break;
            }
            for (Computador computador : computadores) {
                System.out.println(computador);
            }
        }

    }

}
