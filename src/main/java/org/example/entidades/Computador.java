package org.example.entidades;

public class Computador {
    private long id;
    private String marca;
    private String processador;
    private int qnt_ram;
    private int tamanho_disco;

    public Computador(long id, String marca, String processador, int qnt_ram, int tamanho_disco) {
        this.setId(id);
        this.setMarca(marca);
        this.setProcessador(processador);
        this.setQnt_ram(qnt_ram);
        this.setTamanho_disco(tamanho_disco);
    }

    public Computador() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getQnt_ram() {
        return qnt_ram;
    }

    public void setQnt_ram(int qnt_ram) {
        this.qnt_ram = qnt_ram;
    }



    public int getTamanho_disco() {
        return tamanho_disco;
    }

    public void setTamanho_disco(int tamanho_disco) {
        this.tamanho_disco = tamanho_disco;
    }
    @Override
    public String toString() {
        return "Computador{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", processador='" + processador + '\'' +
                ", qnt_ram=" + qnt_ram +
                ", tamanho_disco=" + tamanho_disco +
                '}';
    }
}
