package br.com.pan.bluebank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.bluebank.services.EmailNotificationService;

@RestController
@RequestMapping(path = "v1/notification")
public class NotificationController {

	@Autowired
	private EmailNotificationService notification;	
	
	@GetMapping(path = "/sendmessage", produces= "application/json")
	public ResponseEntity<String> publishMessageToTopic(){	
		 notification.publishMessageToTopic();
		 return ResponseEntity.ok().body("Mensagem enviada com sucesso!");
	}

}
