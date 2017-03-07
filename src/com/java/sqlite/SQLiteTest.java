package com.java.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLiteTest {

    public static void main(String args[]) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:test.db");
            stmt = c.createStatement();
            String sql = "CREATE TABLE PRAISES " +
                         "(ID INT PRIMARY KEY     NOT NULL," +
                         " PRAISE_ENG           TEXT    NOT NULL, " + 
                         " PRAISE_TEL           TEXT    NOT NULL, " + 
                         " VERSE_ENG           TEXT    NOT NULL, " + 
                         " VERSE_TEL           TEXT    NOT NULL)"; 
            stmt.executeUpdate(sql);
            System.out.println("Opened database successfully");

            sql = "INSERT INTO PRAISES (ID,PRAISE_ENG,PRAISE_TEL,VERSE_ENG,VERSE_TEL) " +
                    "VALUES (1, 'Abba Father', 'అబ్బా తండ్రీ', 'Rom 8:15', 'Rom 8:15' );"; 
            stmt.executeUpdate(sql);
            
            ResultSet rs = stmt.executeQuery( "SELECT * FROM PRAISES;" );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String praiseEng = rs.getString("PRAISE_ENG");
                String praiseTel = rs.getString("PRAISE_TEL");
                String verseEng = rs.getString("VERSE_ENG");
                
                System.out.println("ID = " + id + " " + praiseEng + " " + praiseTel + " " + verseEng);
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
