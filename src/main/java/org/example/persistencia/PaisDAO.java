package org.example.persistencia;

import org.example.entidades.Pais;

import java.util.List;

public interface PaisDAO {
    boolean createpais(Pais pais);
    List<Pais> readpais();
    boolean updatepais(Pais pais);
    boolean deletepais(Pais pais);

}
