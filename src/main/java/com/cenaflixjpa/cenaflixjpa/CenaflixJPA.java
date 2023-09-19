
package com.cenaflixjpa.cenaflixjpa;

import com.cenaflixjpa.cenaflixjpa.GUI.TelaLogin;
import com.cenaflixjpa.cenaflixjpa.persistencia.ConectDB;
import static com.cenaflixjpa.cenaflixjpa.persistencia.ConectDB.conectar;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CenaflixJPA {
    
    static PreparedStatement pst;
    static Statement st;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        ConectDB.conectar();
            
        //teste de conexao
        /*try{
        pst = conectar().prepareStatement("insert into usuario (nome, login, senha, tipo) values(?,?,?,?);");
        pst.setString(1, "bryan");
        pst.setString(2, "bryan.silva");
        pst.setString(3, "12345");
        pst.setString(4, "2");
        pst.executeUpdate();
           System.out.println("Registro adicionado com sucesso!");
       } catch (SQLException ex) {
           System.out.println("Erro ao adicionar registro"+ex.getMessage()+pst);
       }*/
        TelaLogin inicio = new TelaLogin();
        inicio.setVisible(true);
        
        
    }
}
