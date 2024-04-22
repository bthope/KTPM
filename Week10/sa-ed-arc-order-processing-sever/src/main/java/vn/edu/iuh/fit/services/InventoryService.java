package vn.edu.iuh.fit.services;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class InventoryService {


    @JmsListener(destination = "processing.order_1")
    public void inventory_listener(Message<String> message){
        String msg = message.getPayload();

        System.out.println("Message received: " +msg);

    }
}
