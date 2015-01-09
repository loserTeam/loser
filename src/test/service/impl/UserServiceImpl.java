package test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import test.dao.UserDao;
import test.entity.UserPo;
import test.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class); 
	
	@Resource
    private UserDao userDao;  

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	public UserPo getUserById(String userId) {
		 log.trace("======trace");  
         log.debug("======debug");  
         log.info("======info");  
         log.warn("======warn");  
         log.error("======error"); 
         
         String name = "Aub";  
         String message = "3Q";  
         String[] fruits = { "apple", "banana" };  
           
         // logback提供的可以使用变量的打印方式，结果为"Hello,Aub!"  
         log.info("Hello,{}!", name);  
           
         // 可以有多个参数,结果为“Hello,Aub! 3Q!”  
         log.info("Hello,{}!   {}!", name, message);  
           
         // 可以传入一个数组，结果为"Fruit:  apple,banana"  
         log.info("Fruit:  {},{}", fruits);   
		 return this.userDao.selectByPrimaryKey(userId);  
	}

	@Override
	public List<UserPo> getAll() {
		return this.userDao.getALL();
	}

	@Override
	public String addInfo(UserPo userPo) {
		if (userDao.insert(userPo) == 1) {
			return "添加成功";
		}
		return "添加失败";
	}

	@Override
	public String delete(String id) {
		if (userDao.deleteByPrimaryKey(id) == 1) {
			return "删除成功";
		}
		return "删除失败";
	}

	@Override
	public UserPo findById(String id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public String update(UserPo userPo) {
		if (userDao.updateByPrimaryKeySelective(userPo) == 1) {
			return "更新成功";
		}
		return "更新失败";
	}

}
