package topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class TopicPublisher {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection=factory.createConnection();
        connection.start();

        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

        Destination destination=session.createTopic("dlte-javaee-assignment");

        MessageProducer provider=session.createProducer(destination);

        Scanner scanner=new Scanner(System.in);
        String inputs="";

        do{
            System.out.println("Send the Problem statement to resource's ");
            inputs= scanner.nextLine();
            TextMessage msg=session.createTextMessage(inputs);
            provider.send(msg);
        }while(!inputs.equalsIgnoreCase("assigned"));

        scanner.close();
        connection.close();
    }
}
