package it.develhope.salacinema;

import java.sql.*;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;



    public void connessioneAlDB() throws Exception {
        // This will load the MySQL driver, each DB has its own driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Setup the connection with the DB
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/multicinema", "root", "JKdordmund234");

        statement = connect.createStatement();

    }
    public void inserisciDatiUtenteDB(String cinemaName, Persona persona, double pagamentoSingolo) throws SQLException {
        preparedStatement = connect
                .prepareStatement("insert into multicinema."+cinemaName+" values (?,?,?,?,?)");

        preparedStatement.setNull(1,5);
        preparedStatement.setString(2, persona.name);
        preparedStatement.setString(3, persona.surname);
        preparedStatement.setInt(4, persona.age);
        preparedStatement.setDouble(5, pagamentoSingolo);
        preparedStatement.executeUpdate();
    }
    public void eliminaDatiUtenteDB(String cinemaName, String cognome) throws SQLException {
        preparedStatement = connect
                .prepareStatement("delete from multicinema."+cinemaName+" where cognome_utente= ? ; ");
        preparedStatement.setString(1,cognome);
        preparedStatement.executeUpdate();
    }


    // You need to close the resultSet
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}

