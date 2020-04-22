package org.example;
// Nomes
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
        this.daoo=daoo;
        this.daao=daao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }
    private void imprimirMenu() {
        int opc;
        int op;

        do {
            System.out.println("= Escolha em qual tabela deseja fazer as alterações: =");
            System.out.println("\t1. Pais");
            System.out.println("\t2. Computador");
            System.out.println("\t3. Aplicativo");
            System.out.println("\t4. Sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1:
                    System.out.println("Tabela pais escolhida:");
                    System.out.println("Escolha a opção do menu:");
                    System.out.println("\t1. Create - Adicionar um pais à tabela");
                    System.out.println("\t2. Read - Ler os dados atuais da tabela");
                    System.out.println("\t3. Update - Atualizar os dados da tabela");
                    System.out.println("\t4. Delete - Deletar um pais da tabela");
                    System.out.println("\t5. Sair - Voltar para  o menu principal");

                    op= in.nextInt();
                    in.nextLine();

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

                    }
                    break;




                case 2:
                    System.out.println("Tabela computador escolhida:");
                    System.out.println("Escolha a opção do menu:");
                    System.out.println("\t1. Create - Adicionar um computador à tabela");
                    System.out.println("\t2. Read - Ler os dados atuais da tabela");
                    System.out.println("\t3. Update - Atualizar os dados da tabela");
                    System.out.println("\t4. Delete - Deletar um pais da tabela");
                    System.out.println("\t5. Sair - Voltar para  o menu principal");

                    op= in.nextInt();
                    in.nextLine();
                    if(op==1){
                     this.createcomputador();
                     }
                      else if(op==2){
                        this.readcomputador();
                      }
                    //  else if(op==3){
                    //   this.update();
                    //  }
                    //   else if (op==4) {
                    //      this.delete();
                    //  }
                      else{}
                    break;
                case 3:
                    System.out.println("Tabela aplicativo escolhida:");
                    System.out.println("Escolha a opção do menu:");
                    System.out.println("\t1. Create - Adicionar um aplicativo à tabela");
                    System.out.println("\t2. Read - Ler os dados atuais da tabela");
                    System.out.println("\t3. Update - Atualizar os dados da tabela");
                    System.out.println("\t4. Delete - Deletar um pais da tabela");
                    System.out.println("\t5. Sair - Voltar para  o menu principal");

                    op= in.nextInt();
                    in.nextLine();
                    if(op==1){
                        this.createaplicativo();
                     }
                    else if (op==2){
                        this.readaplicativo();
                     }
                    //else if (op==3){
                    //    this.update();
                    // }
                    //  else if (op==4){
                    //      this.delete();
                    // }
                      else {}
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (opc != 4);
    }
    private void createpais(){
        Pais controle = new Pais();

        System.out.println("*** Novo pais ***");
        System.out.print("\nInforme o nome do pais: ");
        controle.setNome(in.nextLine());

        System.out.print("Informe a populacao do pais: ");
        controle.setPopulacao(in.nextLong());

        System.out.print("Informe o continente em que o pais esta localizado: ");
        controle.setContinente(in.nextInt());

        System.out.println("Pais adicionado ao banco de Dados");

    }

    private void readpais(){
        List<Pais> paises = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista dos paises cadastrados ***");
        System.out.println("***********************************");
        for (Pais pais : paises) {
            System.out.println(pais);
        }
    }

    private void updatepais(){
        Pais pais = new Pais();

        System.out.println("*** Atualizar um País ***");

        System.out.println("Insira o ID do país que deseja alterar:");
        pais.setId(in.nextInt());

        System.out.println("Altere o nome do país:");
        pais.setNome(in.nextLine());

        System.out.println("Altere o continente do país:");
        pais.setPopulacao(in.nextLong());

        System.out.println("Altere a população do país:");
        pais.setContinente(in.nextInt());


        System.out.println("País atualizado com sucesso.");

    }

    private void deletepais(){
        List<Pais> alunos = dao.read();

        while (true) {
            System.out.println("\n**");
            System.out.println("** Lista de Alunos Cadastrados ");
            System.out.println("**");
            int i = 0;
                for (Pais aluno : alunos) {
                    System.out.println(i + " - " + aluno);
                    i++;
                }
                System.out.println(i + " - Cancelar operação");

                System.out.print("Qual aluno deseja remover? ");
                int opc = in.nextInt();
                //Necessário para ler a quebra de linha (enter)
                in.nextLine();

                if (opc==i) {
                    // Cancelar operação
                    break;
                }

                if (opc >= alunos.size() || opc < 0) {
                    System.out.println("Esta opção não é válida");
                } else {
                    if (dao.delete(alunos.get(opc))) {
                        System.out.println("Aluno " + alunos.get(opc).getNome() +
                                " removido com sucesso");
                    } else {
                        System.out.println("OPS: falar ao tentar remover");
                    }
                    //Isso para o while infinito
                    break;
                }
                for (Pais controle : paises) {
                    System.out.println(controle);
                }
        }

    }
    private void createaplicativo(){
        Aplicativo controle = new Aplicativo();

        System.out.println("*** Novo aplicativo***");

        System.out.print("\nInforme o nome do aplicativo: ");
        controle.setNome(in.nextLine());

        System.out.print("Informe o desenvolvedor do aplicativo: ");
        controle.setDesenvolvedor(in.nextLine());

        System.out.print("Informe o numero de downloads do aplicativo: ");
        controle.setNrm_downloads(in.nextInt());



        System.out.println("Aplicativo adicionado ao banco de Dados");

    }
    private void readaplicativo(){
        List<Aplicativo> aplicativos = daao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista dos aplicativos cadastrados ***");
        System.out.println("***********************************");
        for (Aplicativo aplicativo : aplicativos ) {
            System.out.println(aplicativo);
        }
    }
    private void createcomputador(){
        Computador controle = new Computador();

        System.out.println("*** Novo Computador***");

        System.out.print("\nInforme a marca do computador: ");
        controle.setMarca(in.nextLine());

        System.out.print("Informe o processador do computador: ");
        controle.setProcessador(in.nextLine());

        System.out.print("Informe a quantidade de ram do computador: ");
        controle.setQnt_ram(in.nextInt());

        System.out.print("Informe o tamanho do disco do computador: ");
        controle.setTamanho_disco(in.nextInt());




        System.out.println("Aplicativo adicionado ao banco de Dados");

    }
    private void readcomputador(){
        List<Computador> computadores = daoo.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista dos computadores cadastrados ***");
        System.out.println("***********************************");
        for (Computador computador : computadores ) {
            System.out.println(computador);
        }
    }

}

