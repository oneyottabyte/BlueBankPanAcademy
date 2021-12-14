package br.com.pan.bluebank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.stereotype.Service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@SpringBootApplication (exclude = {ContextInstanceDataAutoConfiguration.class,
		ContextStackAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
@Service
public class EmailNotificationService {
	
    @Autowired
    private AmazonSNSClient snsClient;

    String TOPIC_ARN="arn:aws:sns:us-east-1:085124763691:bluebak";
    
   	public String addSubscription(String email) {
		SubscribeRequest request = new SubscribeRequest(TOPIC_ARN, "email", email);
		snsClient.subscribe(request);
		return "Pedido de inscrição está pendente. Para confirmar verifique seu email : " + email;
	}
	
	public String publishMessageToTopic(){
		 PublishRequest publishRequest=new PublishRequest(TOPIC_ARN, buildEmailBody(), "Agradecimento aos cliente BluebanK");
		 snsClient.publish(publishRequest);		
		 return "Notificação enviada com sucesso !!";
	}


	private String buildEmailBody(){
		return "Cliente Bluebank! "
				+ "\nObrigado por estarem conosco durante o período de teste no PanAcademy! "
				+ "\nEm breve novidades! "
				+ "\n\nEquipe Blueberry";
	}

}
