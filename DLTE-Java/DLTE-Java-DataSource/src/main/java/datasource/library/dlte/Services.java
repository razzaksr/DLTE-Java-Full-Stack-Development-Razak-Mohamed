package datasource.library.dlte;

import oracle.jdbc.driver.OracleDriver;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Services{
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
    public Optional<Transaction> keyBased(int id){
        try {
            query="select * from transaction where transaction_id=?";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return Optional.of(new Transaction(resultSet.getInt("transaction_id"), resultSet.getLong("transaction_from"),resultSet.getLong("transaction_to"),resultSet.getDouble("amount"),resultSet.getDate("happened")));
            }
            else{
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Transaction create(Transaction transaction){
        try {
            query="insert into transaction values(trans_seq.nextval,?,?,?,?)";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setLong(1,transaction.getTransactionFrom());
            preparedStatement.setLong(2,transaction.getTransactionTo());
            preparedStatement.setDouble(3,transaction.getAmount());
            preparedStatement.setString(4,new SimpleDateFormat().format(transaction.getHappened()));
            int acknowledgement=preparedStatement.executeUpdate();
            if(acknowledgement>0){
                return transaction;
            }
            else{
                return null;
            }
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

