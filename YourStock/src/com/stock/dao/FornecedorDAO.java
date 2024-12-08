package com.stock.dao;

import com.stock.factory.ConnectionFactory;
import com.stock.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public static void create(Fornecedor fornecedor){
        String sql = "INSERT INTO fornecedores(codigoFornecedor,nome,email,telefone) VALUES(?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, fornecedor.getCodigoFornecedor());
            pstm.setString(2, fornecedor.getNome());
            pstm.setString(3, fornecedor.getEmail());
            pstm.setString(4, fornecedor.getTelefone());
            pstm.execute();
            System.out.println("Fornecedor salvo com Sucesso!!!");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static List<Fornecedor> getFornecedor(){

        String sql = "SELECT * FROM fornecedores";
        List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){

                Fornecedor fornecedor = new Fornecedor(
                        rst.getInt("codigoFornecedor"),
                        rst.getString("nome"),
                        rst.getString("email"),
                        rst.getString("telefone"));

                fornecedores.add(fornecedor);

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rst != null){
                    rst.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
        return fornecedores;
    }

    public static Fornecedor selectByID(int codigoFornecedor){
        String sql = "SELECT * FROM fornecedores WHERE codigoFornecedor = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,codigoFornecedor);
            rst = pstm.executeQuery();

            while(rst.next()){

                Fornecedor fornecedor1 = new Fornecedor(
                        rst.getInt("codigoFornecedor"),
                        rst.getString("nome"),
                        rst.getString("email"),
                        rst.getString("telefone"));

                return fornecedor1;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(rst != null){
                    rst.close();
                }
                if(pstm != null){
                    pstm.close();
                }
                if(conn != null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void update(Fornecedor fornecedor){
        String sql = "UPDATE fornecedores SET nome = ?, email = ?, telefone = ? WHERE codigoFornecedor = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, fornecedor.getNome());
            pstm.setString(2, fornecedor.getEmail());
            pstm.setString(3, fornecedor.getTelefone());

            pstm.setInt(4, fornecedor.getCodigoFornecedor());

            pstm.execute();
            System.out.println("Fornecedor atualizado com sucesso!!");

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void deleteByID(int codigoFornecedor){
        String sql = "DELETE FROM fornecedores WHERE codigoFornecedor = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoFornecedor);

            pstm.execute();
            System.out.println("Fornecedor deletado com sucesso!!");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
