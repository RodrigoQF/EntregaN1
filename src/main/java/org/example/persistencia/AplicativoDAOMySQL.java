package org.example.persistencia;

import org.example.entidades.Aplicativo;
import org.example.entidades.Computador;
import org.example.entidades.Pais;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicativoDAOMySQL implements AplicativoDAO{

        private String createSQL="INSERT INTO aplicativo (nome, desenvolvedor, nrm_downloads) VALUES(?,?,?)";
        private String readSQL = "SELECT * FROM aplicativo";
        private String updateSQL="UPDATE aplicativo SET nome=?, desenvolvedor=?, nrm_dornloads=? WHERE id=?";
        private String deleteSQL="DELETE FROM aplicativo WHERE id=?";

        private final MySQLConnection mysql = new MySQLConnection();


        @Override
        public boolean create(Aplicativo aplicativo) {
            Connection conexao = mysql.getConnection();
            try {
                PreparedStatement stm = conexao.prepareStatement(createSQL);
                stm.setString(1,aplicativo.getNome());
                stm.setString(2,aplicativo.getDesenvolvedor());
                stm.setInt(3,aplicativo.getNrm_downloads());
                int registro = stm.executeUpdate();
                return (registro > 0);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        @Override
        public List<Aplicativo> read() {
            Connection conexao = mysql.getConnection();
            List<Aplicativo> store = new ArrayList();

            try {
                PreparedStatement pstm = conexao.prepareStatement(readSQL);
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    Aplicativo aplicativo = new Aplicativo();
                    aplicativo.setNome(rs.getString("nome"));
                    aplicativo.setDesenvolvedor(rs.getString("desenvolvedor"));
                    aplicativo.setNrm_downloads(rs.getInt("nmr_downloads"));

                    store.add(aplicativo);
                }

                return store ;

            } catch (final SQLException ex) {
                System.out.println("Falha de conexão com a base de dados!");
                ex.printStackTrace();
            } catch (final Exception ex) {
                ex.printStackTrace();
            } finally {
                try {
                    conexao.close();
                } catch (final Exception ex) {
                    ex.printStackTrace();
                }
            }
            return store;
        }

    @Override
    public boolean update(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(updateSQL);
            System.out.println("Insira o ID do aplicativo que deseja alterar:");
            stm.setLong(1,aplicativo.getId());
            System.out.println("Altere o nome do aplicativo:");
            stm.setString(2,aplicativo.getNome());
            System.out.println("Altere o desenvolvedor do aplicativo:");
            stm.setString(3,aplicativo.getDesenvolvedor());
            System.out.println("Altere o número de downloads do aplicativo:");
            stm.setInt(4,aplicativo.getNrm_downloads());
            int registro = stm.executeUpdate();
            return (registro > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Aplicativo aplicativo) {
        Connection conexao = mysql.getConnection();
        try {
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            System.out.println("Insira o ID do aplicativo que deseja deletar:");
            stm.setLong(1,aplicativo.getId());
            stm.execute();
            int registro = stm.executeUpdate();
            return (registro > 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    }


