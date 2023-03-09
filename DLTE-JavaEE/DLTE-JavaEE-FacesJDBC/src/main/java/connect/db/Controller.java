package connect.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import oracle.jdbc.driver.OracleDriver;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Controller {
    private List<Bankers> everyProfile=new ArrayList<>();

    @PostConstruct
    public void connect(){
        try{
            Driver driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            String qry="select * from bankers";
            PreparedStatement preparedStatement=connection.prepareStatement(qry);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                Bankers bankers=new Bankers();
                bankers.setBanker_name(resultSet.getString("banker_name"));
                bankers.setBanker_passcode(resultSet.getString("banker_passcode"));
                bankers.setBanker_id(resultSet.getInt("banker_id"));
                everyProfile.add(bankers);
            }
        }
        catch (SQLException sql){

        }
    }
}
