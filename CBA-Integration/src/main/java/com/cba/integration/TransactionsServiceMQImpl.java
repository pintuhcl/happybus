package com.cba.integration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.cba.beans.Account;
import com.cba.beans.AccountTransactions;
@Service
public class TransactionsServiceMQImpl
implements  TransactionsServiceMQ{
	@Autowired
private JmsTemplate jmsTemplate;
	@Value("${activemq.destination}")
	private String jmsDestinationQueueName;
	@Override
	public String depositTransactionMessageQueue(String jsonAccount,String jsonAccountTransactions) {
	
		jmsTemplate.send(jmsDestinationQueueName,new MessageCreator() {
		public Message createMessage(Session session)
				throws JMSException {
		Message message=session.createMessage();
		message.setObjectProperty("account",jsonAccount);
		message.setObjectProperty("accountTransactions",jsonAccountTransactions);
			return message;
		}
	});
		return "SUCCESS";
	}

}
