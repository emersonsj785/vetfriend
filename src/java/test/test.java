package test;
import java.sql.Connection;
import util.ConectaBD;

public class test {

    public static void main(String[] args) {
        ConectaBD con = new ConectaBD();
        Connection cnx = null;
        try {
            cnx = con.getConnection();
            System.out.println("Exito");            
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
    
}
