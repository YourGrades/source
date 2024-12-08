package com.stock.dao;

import com.stock.factory.ConnectionFactory;
import com.stock.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {
    public static void create(Produto produto){
        String sql = "INSERT INTO estoque(codigoProduto) VALUES(?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, produto.getCodigoProduto());
            pstm.execute();
            System.out.println("Produto adicionado ao estoque com Sucesso!!!");
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

    public static List<Integer> getProdutoEstoque(){

        String sql = "SELECT * FROM estoque";
        List<Integer> produtos = new ArrayList<Integer>();
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){
                produtos.add(rst.getInt("codigoProduto"));
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
        return produtos;
    }

    public static void deleteByID(int codigoProduto){
        String sql = "DELETE FROM estoque WHERE codigoProduto = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoProduto);

            pstm.execute();
            System.out.println("Produto deletado do estoque com sucesso!!");
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
