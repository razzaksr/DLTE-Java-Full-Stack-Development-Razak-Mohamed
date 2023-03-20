package datasource.library.dlte;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Services {
    private Driver driver;
    private String query;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public Services(){
        try {
            driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            System.out.println("Database Connected");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Transaction> fetch(){
        try {
            query="select * from transaction";
            preparedStatement=connection.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();
            List<Transaction> data=new ArrayList<Transaction>();
            while(resultSet.next()){
                Transaction transaction=new Transaction();
                transaction.setTransactionId(resultSet.getInt("transaction_id"));
                transaction.setTransactionFrom(resultSet.getLong("transaction_from"));
                transaction.setTransactionTo(resultSet.getLong("transaction_to"));
                transaction.setAmount(resultSet.getDouble("amount"));
                transaction.setHappened(resultSet.getDate("happened"));
                data.add(transaction);
            }
            return data;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
