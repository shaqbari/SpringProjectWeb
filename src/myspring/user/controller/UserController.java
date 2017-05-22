package myspring.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.dao.UserDao;
import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserList.do")
	public String getUserList(Model model) {
		List<UserVO> userList=userService.getUserList();
		model.addAttribute("userList", userList);
		
		return "userList";
	}
	
	@RequestMapping("/getUser.do")
	public ModelAndView getUser(@RequestParam String id) {
		UserVO user=userService.getUser(id);
		
		return new ModelAndView("userInfo", "user", user);		
		
	}
	
	@RequestMapping("/insertUserForm.do")
	public ModelAndView insertUserForm(){
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		
		//원래는 db에서 가져와야 함
		List<String> cityList=new ArrayList<String>();
		cityList.add("서울"); 
		cityList.add("부산"); 
		cityList.add("대구"); 
		cityList.add("제주");
		
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		
		return new ModelAndView("userInsert", "map", map);
		
	}	
	
	@RequestMapping("/insertUser.do")
	public String insertUser(@ModelAttribute UserVO user) {
		//@ModelAttribute를 사용하면 parameter name과 dto의 멤버변수 이름이 같으면 자동으로 입력해준다.
		if(user!=null){
			userService.insertUser(user);
		}
		
		return "redirect:/getUserList.do";//자동으로 사용자 목록을 얻게 처리한다.
	}

	@RequestMapping("/updateUserForm.do")	
	public ModelAndView updateUserForm(@RequestParam String id) {
		//보내온 id로 user정보를 db에서 조회하고 model에 담아 보냄
		UserVO user=userService.getUser(id);
		
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		
		List<String> cityList=new ArrayList<String>();
		cityList.add("서울"); 
		cityList.add("부산"); 
		cityList.add("대구"); 
		cityList.add("제주");

		Map<String, Object> map=new HashMap<String, Object>();
		map.put("user", user);
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		
		return new ModelAndView("userUpdate", "map", map);
	}

	@RequestMapping("updateUser.do")
	public String updateUser(@ModelAttribute UserVO user){
		if(user!=null){
			userService.updateUser(user);
		}
		
		return "redirect:/getUserList.do";
		
	}
	
	
	/**
	 * @param id
	 * @return
	 * 
	 * @PathVariable을 쓰면 @RequestMapping에 지정한 path변수를 받을 수 있다.
	 * restful쓸때 이와 같은 방법으로 data 전달을 많이 한다.
	 * web.xml에서 DispatherSevlet의 urlpattern을 /로 변경해야 사용가능하다.
	 */
	@RequestMapping("deleteUser.do/{id}")
	public String delete(@PathVariable String id){				
		if(id!=null){
			userService.deleteUser(id);
		}		
		
		return "redirect:/getUserList.do";
	}
	
	@ExceptionHandler
	public String handleException(Exception e){
		return "viewError";
		
	}
	
}
