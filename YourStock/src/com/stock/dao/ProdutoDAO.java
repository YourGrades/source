package com.stock.dao;

import com.stock.factory.ConnectionFactory;
import com.stock.model.Produto;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class ProdutoDAO {

    public static void create(Produto produto){
        String sql = "INSERT INTO produtos(nome,descricao,preco,categoria,quantidadeEstoque,codigoFornecedor) VALUES(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setDouble(3, produto.getPreco());
            pstm.setString(4, produto.getCategoria());
            pstm.setInt(5, produto.getQuantidadeEstoque());
            pstm.setInt(6, produto.getCodigoFornecedor());
            pstm.execute();
            System.out.println("Produto salvo com Sucesso!!!");
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

    public static List<Produto> getProduto(){

        String sql = "SELECT * FROM produtos";
        List<Produto> produtos = new ArrayList<Produto>();
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            rst = pstm.executeQuery();

            while(rst.next()){

                Produto produto = new Produto(
                        rst.getInt("codigoProduto"),
                        rst.getString("nome"),
                        rst.getString("descricao"),
                        rst.getDouble("preco"),
                        rst.getString("categoria"),
                        rst.getInt("quantidadeEstoque"),
                        rst.getInt("codigoFornecedor"));

                produtos.add(produto);

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

    public static Produto selectByID(int codigoProduto){
        String sql = "SELECT * FROM produtos WHERE codigoProduto = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rst = null;
        try{
            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,codigoProduto);

            rst = pstm.executeQuery();

            while(rst.next()){

                Produto produto1 = new Produto(
                        rst.getInt("codigoProduto"),
                        rst.getString("nome"),
                        rst.getString("descricao"),
                        rst.getDouble("preco"),
                        rst.getString("categoria"),
                        rst.getInt("quantidadeEstoque"),
                        rst.getInt("codigoFornecedor"));

                return produto1;
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

    public static void update(Produto produto){
        String sql = "UPDATE produtos SET nome = ?, descricao = ?, preco = ?, categoria = ?, quantidadeEstoque = ?, codigoFornecedor = ? WHERE codigoProduto = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricao());
            pstm.setDouble(3, produto.getPreco());
            pstm.setString(4, produto.getCategoria());
            pstm.setInt(5, produto.getQuantidadeEstoque());
            pstm.setInt(6, produto.getCodigoFornecedor());

            pstm.setInt(7, produto.getCodigoProduto());

            pstm.execute();
            System.out.println("Produto atualizado com sucesso!!");

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

    public static void updateQtd(Produto prodUpQtd){
        String sql = "UPDATE produtos SET quantidadeEstoque = ? WHERE codigoProduto = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{

            conn = ConnectionFactory.getConnection();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, prodUpQtd.getQuantidadeEstoque());

            pstm.setInt(2, prodUpQtd.getCodigoProduto());

            pstm.execute();
            System.out.println("Produto atualizado com sucesso!!");

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteByID(int codigoProduto){
        String sql = "DELETE FROM produtos WHERE codigoProduto = ?";

        Connection conn = null;

        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, codigoProduto);

            pstm.execute();
            System.out.println("Produto deletado com sucesso!!");
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
