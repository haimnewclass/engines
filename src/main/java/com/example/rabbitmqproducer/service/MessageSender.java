package com.example.rabbitmqproducer.service;

import com.haimsoft.engines.config.RabbitConfig;

// Ensure RabbitConfig is correctly imported and exists in the specified package
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSender {

    private final AmqpTemplate rabbitTemplate;

    public MessageSender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String message) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        try {
            rabbitTemplate.convertAndSend(
                    RabbitConfig.EXCHANGE_NAME,
                    RabbitConfig.ROUTING_KEY,
                    message
            );
            System.out.println("📤 Message sent: " + message);
        } catch (Exception e) {
            System.err.println("❌ Failed to send message: " + e.getMessage());
        }
    }
}