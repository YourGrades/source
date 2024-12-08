package com.stock.dao;

import com.stock.factory.ConnectionFactory;
import com.stock.model.Entrega;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

    public static void create(Entrega entrega){
        String sql = "INSERT INTO entregas(dataEntrega,status,descricao,qtdEntrega,codigoProduto) VALUES(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, entrega.getDataEntrega());
            pstm.setString(2, entrega.getStatus().toString());
            pstm.setString(3, entrega.getDescricao());
            pstm.setInt(4, entrega.getQtdEntrega());
            pstm.setInt(5, entrega.getCodigoProduto());
            pstm.execute();
            System.out.println("Entrega salva com Sucesso!!!");
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

    public static List<Entrega> getEntrega(){

        String sql = "SELECT * FROM entregas";
        List<Entrega> entregas = new ArrayList<Entrega>();
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){

                Entrega entrega = new Entrega(
                        rst.getInt("codigoEntrega"),
                        rst.getString("dataEntrega"),
                        rst.getString("descricao"),
                        rst.getInt("qtdEntrega"),
                        rst.getInt("codigoProduto"));

                if(rst.getString("status").equals("ENVIADO")){
                    entrega.atualizarStatus(1);
                } else if(rst.getString("status").equals("ENTREGUE")){
                    entrega.atualizarStatus(2);
                } else {
                    entrega.atualizarStatus(0);
                }

                entregas.add(entrega);

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
        return entregas;
    }

    public static Entrega selectByID(int codigoEntrega){
        String sql = "SELECT * FROM entregas WHERE codigoEntrega = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,codigoEntrega);
            rst = pstm.executeQuery();

            while(rst.next()){

                Entrega entrega1 = new Entrega(
                        rst.getInt("codigoEntrega"),
                        rst.getString("dataEntrega"),
                        rst.getString("descricao"),
                        rst.getInt("qtdEntrega"),
                        rst.getInt("codigoProduto"));

                return entrega1;
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

    public static void update(Entrega entrega){
        String sql = "UPDATE entregas SET dataEntrega = ?, status = ?, descricao = ?, qtdEntrega = ?, codigoProduto = ? WHERE codigoEntrega = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, entrega.getDataEntrega());
            pstm.setString(2, entrega.getStatus().toString());
            pstm.setString(3, entrega.getDescricao());
            pstm.setInt(4, entrega.getQtdEntrega());
            pstm.setInt(5, entrega.getCodigoProduto());

            pstm.setInt(6, entrega.getCodigoEntrega());

            pstm.execute();
            System.out.println("Entrega atualizada com sucesso!!");

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

    public static void updateStatus(Entrega entrega){
        String sql = "UPDATE entregas SET status = ? WHERE codigoEntrega = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, entrega.getStatus().toString());
            pstm.setInt(2, entrega.getCodigoEntrega());

            pstm.execute();

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

    public static void deleteByID(int codigoEntrega){
        String sql = "DELETE FROM entregas WHERE codigoEntrega = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoEntrega);

            pstm.execute();
            System.out.println("Entrega deletada com sucesso!!");
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
