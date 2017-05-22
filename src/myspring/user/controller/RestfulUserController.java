package myspring.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.UserVOXML;

@Controller
public class RestfulUserController {
	@Autowired
	private UserService userService;
	
	/*	�׽�Ʈ�Ϸ��� �Ʒ� lib���� �߰��ؾ� �Ѵ�.
	 * jackson-databind
	*/
	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public Map getUserList() {
	//public Map<String, List<UserVO>> name() {
		List<UserVO> userList = userService.getUserList();
		//Map result=new HashMap<String, List<UserVO>>();
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);//���⼭ boolean�� �������� generic�� ���� �ȵȴ�.
		result.put("data", userList);		
		
		return result;
	}
		
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map getUser(@PathVariable String id) {
		UserVO user = userService.getUser(id);
		Map result = new HashMap();
		result.put("result", Boolean.TRUE);
		result.put("data", user);
		return result;
	}
	
	/*Responsebody�� ���� ��� user.jsp���� userModel��ü�� �����Ѵ�.
	 * @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)	
	public String getUser2(@PathVariable String id, ModelMap model) {
		UserVO user = userService.getUser(id);		
		model.addAttribute("result", Boolean.TRUE);
		model.addAttribute("data", user);
		
		return "user";
	}*/
	
	
	
	@RequestMapping(value="/users",
					method=RequestMethod.POST,
					headers={"Content-type=application/json"})
	@ResponseBody
	public Map insertUser(@RequestBody UserVO user) {
		//��û ��ü�� json�̶� @pathVariable�� �ƴ� @RequestBody annotation�� ����Ѵ�.
		if (user!=null) {
			userService.insertUser(user);
		}
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);
		
		return result;
	}
	
	@RequestMapping(value="/users",
					method=RequestMethod.PUT,
					headers={"Content-type=application/json"})
	@ResponseBody
	public Map updateUser(@RequestBody UserVO user) {
		//��û ��ü�� json�̶� @pathVariable�� �ƴ� @RequestBody annotation�� ����Ѵ�.
		if (user!=null) {
			userService.updateUser(user);
		}
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);
		
		return result;
	}
	
	@RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public Map deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);
		
		return result;		
	}
	
	@RequestMapping(value="/usersXml",
			method=RequestMethod.GET)
	@ResponseBody
	public UserVOXML getUserListXml() {
		List<UserVO> list = userService.getUserList();
		UserVOXML xml = new UserVOXML("success", list);//��Ŭ������ list�� xml�� �ٲپ��ִµ� ���δ�.
		return xml;
	}	
}
