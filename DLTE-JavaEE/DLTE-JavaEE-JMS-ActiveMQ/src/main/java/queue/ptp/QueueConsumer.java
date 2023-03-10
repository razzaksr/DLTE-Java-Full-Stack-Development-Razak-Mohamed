package queue.ptp;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Console;

public class QueueConsumer {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection=factory.createConnection();
        connection.start();

        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Destination destination=session.createQueue("dltepoint2point");

        MessageConsumer consumer= session.createConsumer(destination);

        TextMessage message;

        Console console=System.console();
        String info="";
        do{
            message= (TextMessage) consumer.receive();
            info=(String)message.getText();
            System.out.println("Message from queue "+info);
        }while(!info.equalsIgnoreCase("call for the day"));

        connection.close();

    }
}
