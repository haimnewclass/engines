package com.haimsoft.engines.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.rabbitmqproducer.service.MessageSender;
import com.haimsoft.engines.service.ListenerControlService;


@RestController
public class HelloController {
    
    private final MessageSender messageSender;
     private final ListenerControlService listenerControlService;

    public HelloController(MessageSender messageSender,ListenerControlService listenerControlService) {
        this.messageSender = messageSender;
        this.listenerControlService = listenerControlService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "שלום עולם!";
    }
    @GetMapping("/")
    public String home() {
        return "homepage!";
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        messageSender.sendMessage(message);
        return "Message sent: " + message;
    }

    @GetMapping("/start")
    public String startQ() {
        listenerControlService.startListener();
        return "Queue is started";
    }

    @GetMapping("/stop")
    public String stopQ() {
        listenerControlService.stopListener();
        return "Queue is started";
    }

    
}
