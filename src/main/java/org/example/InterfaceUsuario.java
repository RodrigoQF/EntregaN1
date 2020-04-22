package org.example;
// Nomes
import org.example.entidades.Aplicativo;
import org.example.entidades.Computador;
import org.example.entidades.Pais;
import org.example.persistencia.AplicativoDAO;
import org.example.persistencia.ComputadorDAO;
import org.example.persistencia.PaisDAO;

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
                int op;
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
                        this.create();
                    }
                    else if (op==2){
                        this.read();
                    }
                    else if (op==3){
                        this.update();
                    }
                    else if (op==4){
                        this.delete();
                    }
                    else {}
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
                        this.create();
                    }
                    else if(op==2){
                        this.read();
                    }
                    else if(op==3){
                        this.update();
                    }
                    else if (op==4) {
                        this.delete();
                    }
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
                        this.create();
                    }
                    else if (op==2){
                        this.read();
                    }
                    else if (op==3){
                        this.update();
                    }
                    else if (op==4){
                        this.delete();
                    }
                    else {}
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (opc != 4);
    }

    }
