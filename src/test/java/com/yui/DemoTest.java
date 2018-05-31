package com.yui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.utils.SerializationUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class DemoTest {
	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		factory.setPort(5672);
		factory.setUsername("guest");
		factory.setPassword("guest");
		//Connection conn = factory.newConnection("test");
		Address addr = new Address("localhost", 5672);
		Address[] addrs = new Address[]{addr};
		Connection conn =factory.newConnection(addrs);
		System.out.println(conn.getPort());
		
		Channel channel = conn.createChannel();
//        //声明交换器
//        String exchangeName = "hello-exchange";
//        channel.exchangeDeclare(exchangeName, "direct", true);
//
//        String routingKey = "hola";
//        //发布消息
//        byte[] messageBodyBytes = "quit".getBytes();
//        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
		//channel.basicPublish("", "hello", null, message.getBytes());
		//channel.exchangeDeclare("hehehe", "topic");
		channel.queueDeclare("biubiu~2", true, false, false, null);
		channel.queueDeclare("biubiu~3", true, false, false, null);
		channel.queueDeclare("biubiu~4", true, false, false, null);
		channel.queueDeclare("biubiu~5", true, false, false, null);
		int a = 1;
		Map<String, Object> messageModel = new HashMap<String, Object>();
		messageModel.put("action", "ticket");
		messageModel.put("mobile", "18114926281");
		messageModel.put("plateNo", "今天的风儿好喧嚣啊");
		messageModel.put("door", "喂喂");
		messageModel.put("progress", "哈哈哈哈哈哈哈哈");
		while(true){
	         try {

	                
	//            	channel.basicPublish("hehehe1", "topic.message", MessageProperties.PERSISTENT_TEXT_PLAIN,"大话西游".getBytes());
	        	   ObjectMapper mapper=new ObjectMapper();
	               String message=mapper.writeValueAsString(messageModel);
	        	 
	        	 channel.basicPublish("hehehe1", "topic.message", MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
	            	Thread.sleep(20000);//睡眠1秒。循环300次就是300秒也就是五分钟
//	                a = a+1;
//	            	String m = (char)a+"";
//	            	String m1 = (char)(a+500)+"";
//	            	String m2 = (char)(a+2500)+"";
//	            	String m3 = (char)(a+5500)+"";
//	    			channel.basicPublish("", "biubiu~2", MessageProperties.PERSISTENT_TEXT_PLAIN, m.getBytes());
//	    			channel.basicPublish("", "biubiu~3", MessageProperties.PERSISTENT_TEXT_PLAIN, m1.getBytes());
//	    			channel.basicPublish("", "biubiu~4", MessageProperties.PERSISTENT_TEXT_PLAIN, m2.getBytes());
//	    			channel.basicPublish("", "biubiu~5", MessageProperties.PERSISTENT_TEXT_PLAIN, m3.getBytes());
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
		
		}
		

       


	}

}
