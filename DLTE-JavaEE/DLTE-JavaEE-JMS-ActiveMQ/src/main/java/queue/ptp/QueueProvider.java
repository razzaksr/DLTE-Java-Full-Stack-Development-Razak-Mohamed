package queue.ptp;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class QueueProvider {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection=factory.createConnection();
        connection.start();

        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Destination destination=session.createQueue("dltepoint2point");

        MessageProducer provider=session.createProducer(destination);

        Scanner scanner=new Scanner(System.in);
        String inputs="";

        do{
            System.out.println("Send the information to consumer ");
            inputs= scanner.nextLine();
            TextMessage msg=session.createTextMessage(inputs);
            provider.send(msg);
        }while(!inputs.equalsIgnoreCase("call for the day"));

        scanner.close();
        connection.close();
    }
}
