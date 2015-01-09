package test.service;

import java.util.List;

import test.entity.UserPo;

public interface UserService {
	public UserPo getUserById(String userId);

	public List<UserPo> getAll();

	public String addInfo(UserPo userPo);

	public String delete(String id);

	public UserPo findById(String tid);

	public String update(UserPo userPo);  
}	
