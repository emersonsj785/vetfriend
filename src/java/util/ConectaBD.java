package util;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBD implements Serializable {
    private final String URL = "jdbc:mysql://localhost:3306/vetfriend";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USER = "root";
    private final String PASS = "";
    
    public Connection getConnection() throws SQLException{
    Connection c = null;
        try {
            Class.forName(DRIVER).newInstance();
            c = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | 
                 IllegalAccessException | 
                 InstantiationException | 
                 SQLException e) {
            throw new SQLException(e.getMessage());
        }    
    return c;
    }
}

/*
CREATE TABLE `events`.`servicios` ( 
`id` INT NOT NULL AUTO_INCREMENT , 
`nombre` VARCHAR(50) NOT NULL , 
`descripcion` TEXT NOT NULL , 
`precio` DECIMAL(10,2) NOT NULL , 
PRIMARY KEY (`id`)) ENGINE = InnoDB;
*/

/*
CREATE TABLE `events`.`contacto` ( 
`dni` INT(8) NOT NULL , 
`nombre` VARCHAR(50) NOT NULL , 
`mensaje` TEXT NOT NULL , 
`telefono` INT(9) NOT NULL ) ENGINE = InnoDB;
*/
