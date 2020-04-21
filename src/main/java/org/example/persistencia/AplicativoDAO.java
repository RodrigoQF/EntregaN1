package org.example.persistencia;

import org.example.entidades.Aplicativo;


import java.util.List;

public interface AplicativoDAO {

        boolean create(Aplicativo aplicativo);
        List<Aplicativo> read();
        boolean update(Aplicativo aplicativo);
        boolean delete(Aplicativo aplicativo);
    }

