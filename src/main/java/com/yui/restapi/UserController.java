package com.yui.restapi;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yui.model.User;
import com.yui.restmodel.UserModel;
import com.yui.service.UserService;
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/save",method = RequestMethod.POST)
	public Map<String,Object> saveUser(@RequestBody @Valid UserModel model,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		User user = new User();
		user.setAccount(model.getAccount());
		user.setPassword(model.getPassword());
		userService.save(user);
		
		map.put("action", "ok");
		return map;
		
		
		
	}
	

}
