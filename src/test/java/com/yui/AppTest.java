package com.yui;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.yui.dao.UserDao;
import com.yui.model.User;
import com.yui.service.UserService;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class) //initializers = ConfigFileApplicationContextInitializer.class
@Transactional
public class AppTest {
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;

	@Test

	public void contextLoads() {
		User user = userDao.findById(1);
		if (user==null){
			
			System.out.println("ok");
		}else{
			
			System.out.println(user);
		}
		
		
	}
	
	@Test
	public void testAll() throws IOException, TimeoutException{
//		List<User> users = userDao.getAll();
//		System.out.println(users);
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare("hello", false, false, false, null);
	}
	
	@Rollback(false)
	@Test
	public void contextLoads_1() {
		User user = new User();
		user.setPassword("ll");
		user.setAccount("yloly");
		
		user = userService.save(user);
//		UserCompany uc = new UserCompany();
//		uc.setUid(user.getId());
		
		System.out.println(user);
	}

}
