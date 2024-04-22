package vn.edu.iuh.fit.services;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class OrderServices {

    private final JmsTemplate template;

    public OrderServices(JmsTemplate template) {
        this.template = template;
    }

    public void sendOrder(String destinationName, String orderInfos_JSON){
        Destination destination = new ActiveMQTopic(destinationName);
        template.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(orderInfos_JSON);
            }
        });
    }
}
