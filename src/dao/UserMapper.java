package dao;

import java.util.List;

import pojo.Role;
import pojo.User;

public interface UserMapper {
	
	public int count() ;
	
	public void add(User user);
	
	public void	update(User user);
	
	public void delete(User user);
	
	public List<User> getUserList();
	
	public List<User> getUserListByRoleId(Role role);

	//动态SQL语句测试
	public void updateUserInfo(User user);
}
