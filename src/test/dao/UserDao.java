package test.dao;

import java.util.List;

import test.entity.UserPo;

public interface UserDao {
    int deleteByPrimaryKey(String id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    UserPo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);

	List<UserPo> getALL();
}