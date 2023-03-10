package topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Console;

public class TopicSubscribers {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection=factory.createConnection();
        connection.start();

        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Destination destination=session.createTopic("dlte-javaee-assignment");

        MessageConsumer subscriber= session.createConsumer(destination);

        TextMessage message;

        Console console=System.console();
        String info="";
        do{
            message= (TextMessage) subscriber.receive();
            info=(String)message.getText();
            System.out.println("Message from dlte "+info);
        }while(!info.equalsIgnoreCase("assigned"));

        connection.close();
    }
}
