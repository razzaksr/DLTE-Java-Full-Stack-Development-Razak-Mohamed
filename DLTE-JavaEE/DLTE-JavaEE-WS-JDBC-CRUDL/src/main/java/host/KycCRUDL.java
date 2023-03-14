package host;

import oracle.jdbc.driver.OracleDriver;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.io.InputStream;
import java.sql.*;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class KycCRUDL {
    private Driver driver;
    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public KycCRUDL(){
        try {
            driver=new OracleDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
            System.out.println("Connection towards Oracle is success");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @WebMethod
    @WebResult(name = "ResponseMessage")
    public String addKyc(@WebParam(name="KYC") KYC kyc){
        try{
            query="insert into kyc values(kyc_seq.nextval,?,?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(query);
            preparedStatement.setString(1,kyc.getPasscode());
            preparedStatement.setString(2,kyc.getAcc_holder());
            preparedStatement.setLong(3,kyc.getAadhaar());
            preparedStatement.setString(4,kyc.getPan());
            preparedStatement.setString(5,kyc.getEmail());
            preparedStatement.setLong(6,kyc.getContact());
            preparedStatement.setDouble(7,kyc.getAcc_bal());
            preparedStatement.setString(8,kyc.getAddress());
            int ack= preparedStatement.executeUpdate();
            if(ack>0)
                return kyc.getAcc_holder()+" account has created";
            else
                return kyc.getAcc_holder()+" account hasn't created";
        }
        catch (SQLException sqlException){}
        return "";
    }

    @WebMethod
    @WebResult(name="ListOfKYC")
    public ListOfKYC fetch(){
        ListOfKYC listOfKYC=new ListOfKYC();
        try {
            query="select * from kyc";
            preparedStatement= connection.prepareStatement(query);
            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                KYC kyc=new KYC();
                kyc.setAddress(resultSet.getString("address"));
                kyc.setAadhaar(resultSet.getLong("aadhaar"));
                kyc.setContact(resultSet.getLong("contact"));
                kyc.setPan(resultSet.getString("pan"));
                kyc.setAcc_bal(resultSet.getDouble("acc_bal"));
                kyc.setEmail(resultSet.getString("email"));
                kyc.setAcc_holder(resultSet.getString("acc_holder"));
                kyc.setPasscode(resultSet.getString("passcode"));
                kyc.setAcc_number(resultSet.getInt("acc_number"));
                listOfKYC.getKycs().add(kyc);
            }
            //connection.close();
            return listOfKYC;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
