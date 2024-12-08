package com.stock.dao;

import com.stock.factory.ConnectionFactory;
import com.stock.model.Recebimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RecebimentoDAO {

    public static void create(Recebimento recebimento){
        String sql = "INSERT INTO recebimentos(descricao,qtdRecebe,codigoProduto) VALUES(?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, recebimento.getDescricao());
            pstm.setInt(2, recebimento.getQtdRecebe());
            pstm.setInt(3, recebimento.getCodigoProduto());
            pstm.execute();
            System.out.println("Recebimento salvo com Sucesso!!!");
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

    public static List<Recebimento> getRecebimento(){

        String sql = "SELECT * FROM recebimentos";
        List<Recebimento> recebimentos = new ArrayList<Recebimento>();
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){

                Recebimento recebimento = new Recebimento(
                        rst.getInt("codigoRecebimento"),
                        rst.getString("descricao"),
                        rst.getInt("qtdRecebe"),
                        rst.getInt("codigoProduto"));

                recebimentos.add(recebimento);

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
        return recebimentos;
    }

    public static Recebimento selectByID(int codigoRecebimento){
        String sql = "SELECT * FROM recebimentos WHERE codigoRecebimento = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,codigoRecebimento);
            rst = pstm.executeQuery();

            while(rst.next()){

                Recebimento receb1 = new Recebimento(
                        rst.getInt("codigoRecebimento"),
                        rst.getString("descricao"),
                        rst.getInt("qtdRecebe"),
                        rst.getInt("codigoProduto"));

                return receb1;
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

    public static void update(Recebimento recebimento){
        String sql = "UPDATE recebimentos SET descricao = ?, qtdRecebe = ?, codigoProduto = ? WHERE codigoRecebimento = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, recebimento.getDescricao());
            pstm.setInt(2, recebimento.getQtdRecebe());
            pstm.setInt(3, recebimento.getCodigoProduto());

            pstm.setInt(4, recebimento.getCodigoRecebimento());

            pstm.execute();
            System.out.println("Recebimento atualizado com sucesso!!");

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

    public static void deleteByID(int codigoRecebimento){
        String sql = "DELETE FROM recebimentos WHERE codigoRecebimento = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoRecebimento);

            pstm.execute();
            System.out.println("Recebimento deletado com sucesso!!");
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
