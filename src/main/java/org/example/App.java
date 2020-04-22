package org.example;

import org.example.persistencia.AplicativoDAOMySQL;
import org.example.persistencia.ComputadorDAOMySQL;
import org.example.persistencia.PaisDAOMySQL;

public class App {
    public static void main( String[] args ) {
        PaisDAOMySQL mysqlDAO = new PaisDAOMySQL();
        ComputadorDAOMySQL mysqllDAO = new ComputadorDAOMySQL();
        AplicativoDAOMySQL mysqlllDAO = new AplicativoDAOMySQL();

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(mysqlDAO, mysqllDAO, mysqlllDAO);
        interfaceUsuario.iniciar();
    }
}

