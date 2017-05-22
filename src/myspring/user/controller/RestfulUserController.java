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
	
	/*	테스트하려면 아래 lib도를 추가해야 한다.
	 * jackson-databind
	*/
	@RequestMapping(value="/users", method=RequestMethod.GET)
	@ResponseBody
	public Map getUserList() {
	//public Map<String, List<UserVO>> name() {
		List<UserVO> userList = userService.getUserList();
		//Map result=new HashMap<String, List<UserVO>>();
		Map result=new HashMap();
		result.put("result", Boolean.TRUE);//여기서 boolean을 넣으려면 generic을 쓰면 안된다.
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
	
	/*Responsebody가 없는 경우 user.jsp에서 userModel객체를 참조한다.
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
		//요청 객체가 json이라 @pathVariable이 아닌 @RequestBody annotation을 사용한다.
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
		//요청 객체가 json이라 @pathVariable이 아닌 @RequestBody annotation을 사용한다.
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
		UserVOXML xml = new UserVOXML("success", list);//이클래스가 list를 xml로 바꾸어주는데 쓰인다.
		return xml;
	}	
}
