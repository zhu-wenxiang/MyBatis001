package dao;

import java.util.List;

import pojo.Role;

public interface RoleDao {

	public void add(Role role);

	public void update(Role role);
	
	public void delete(Role role);

	public List<Role> getRoleList();
	
	//测试动态SQL语句
	public List<Role> getRoleListByPara(Role role);
}
