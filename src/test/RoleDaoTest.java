package test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import dao.RoleDao;
import pojo.Role;
import utils.MyBatisUtil;

public class RoleDaoTest {

	private Logger logger=Logger.getLogger(RoleDaoTest.class);

	@Test
	public void getRoleListtest() {
		List<Role> roleList=new ArrayList<Role>();
		SqlSession session=MyBatisUtil.getSqlSession();
		roleList=session.getMapper(RoleDao.class).getRoleList();
		for (Role role : roleList) {
			logger.info("取到的roleName有"+role.getRoleName());
		}
		MyBatisUtil.closeSqlSession(session);
	}

}
