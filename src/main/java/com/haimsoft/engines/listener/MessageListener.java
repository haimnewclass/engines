package com.haimsoft.engines.listener;

import com.haimsoft.engines.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME, id = RabbitConfig.LISTENER_ID,autoStartup = "true")
    public void receiveMessage(String message) {
        System.out.println("MEssage Recieved : " + message);
    }
}
