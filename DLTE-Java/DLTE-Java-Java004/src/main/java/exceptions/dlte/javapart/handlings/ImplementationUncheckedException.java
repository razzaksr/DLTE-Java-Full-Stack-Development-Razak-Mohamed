package exceptions.dlte.javapart.handlings;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImplementationUncheckedException {

    static Logger logger=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);// singleton design

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        logger.log(Level.CONFIG,"Scanner configured");
        double[][] stockValue={{4500.3,12900.5,5600.4},{783.5,98.2,14500}};
        int row=0,column=0;
        logger.log(Level.INFO,"Data are set to process");
        // read by row and column
        try{
            System.out.println("Enter the row and column ");
            row= scanner.nextInt();
            column= scanner.nextInt();
            logger.log(Level.INFO,"Data were received by user inputs");
            System.out.println(stockValue[row][column]);
        }
        catch(ArrayIndexOutOfBoundsException object){
            logger.log(Level.WARNING,"Exception occurred it will be handled");
            //object.printStackTrace();
            System.out.println(object);
            System.out.println("Enter the row within "+stockValue.length+" and column within "+stockValue[0].length);
            row= scanner.nextInt();
            column= scanner.nextInt();
            System.out.println(stockValue[row][column]);
        }
        finally {
            logger.log(Level.FINE,"Process Complete ");
            System.out.println("Stock reading process is over");
        }
        scanner.close();
    }
}
