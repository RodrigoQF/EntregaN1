package org.example.persistencia;

import org.example.entidades.Computador;

import java.util.List;

public interface ComputadorDAO {

    boolean createcomputador(Computador computador);
    List<Computador> readcomputador();
    boolean updatecomputador(Computador computador);
    boolean deletecomputador(Computador computador);
}
