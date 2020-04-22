package org.example.persistencia;

import org.example.entidades.Aplicativo;


import java.util.List;

public interface AplicativoDAO {

        boolean createaplicativo(Aplicativo aplicativo);
        List<Aplicativo> readaplicativo();
        boolean updateaplicativo(Aplicativo aplicativo);
        boolean deleteaplicativo(Aplicativo aplicativo);
    }

