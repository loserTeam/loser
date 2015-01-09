package test.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import test.entity.UserPo;
import test.service.UserService;

@Controller
public class TestController {
	private static Logger log = LoggerFactory.getLogger(TestController.class); 
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("finally")
	@RequestMapping("addInfo")
	public String add(UserPo userPo,HttpServletRequest request){
		try {		
			String id = UUID.randomUUID().toString();
			log.info("id: {}",id);
			userPo.setId(id);
			log.info("userPo: {},{},{}",userPo.getId(), userPo.getName(), userPo.getPwd());
			String str = userService.addInfo(userPo);
			log.info("新增结果: {}",str);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "添加信息失败！具体异常信息：" + e.getMessage());
		} finally {			
			return "test/result";
		}
	}
	
	@RequestMapping("getAll")
	public String getAddInfoAll(HttpServletRequest request){
		try {			
			List<UserPo> list = userService.getAll();
			System.out.println(list);
			request.setAttribute("addLists", list);
			return "test/list";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return "test/result";
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping("del")
	public String del(String id,HttpServletRequest request){
		try {			
			String str = userService.delete(id);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "删除信息失败！具体异常信息：" + e.getMessage());
		} finally {			
			return "test/result";
		}
	}
	@RequestMapping("modify")
	public String modify(String id,HttpServletRequest request){
		try {			
			UserPo userPo = userService.findById(id);
			request.setAttribute("userPo", userPo);
			return "test/modify";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "信息载入失败！具体异常信息：" + e.getMessage());
			return "test/result";
		}
	}
	@SuppressWarnings("finally")
	@RequestMapping("update")
	public String update(UserPo userPo,HttpServletRequest request){
		try {			
			String str = userService.update(userPo);
			request.setAttribute("InfoMessage", str);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("InfoMessage", "更新信息失败！具体异常信息：" + e.getMessage());
		} finally {			
			return "test/result";
		}
	}
}
