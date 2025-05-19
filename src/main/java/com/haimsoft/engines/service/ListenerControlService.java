package com.haimsoft.engines.service;

import com.haimsoft.engines.config.RabbitConfig;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistry;
import org.springframework.stereotype.Service;

@Service
public class ListenerControlService {

    private final RabbitListenerEndpointRegistry registry;

    public ListenerControlService(RabbitListenerEndpointRegistry registry) {
        this.registry = registry;
    }

    public void stopListener() {
        registry.getListenerContainer(RabbitConfig.LISTENER_ID).stop();
        System.out.println("Listener stopped.");
    }

    public void startListener() {
        registry.getListenerContainer(RabbitConfig.LISTENER_ID).start();
        System.out.println("Listener started.");
    }
}