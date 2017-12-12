package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.UserMapper;
import pojo.Role;
import pojo.User;
import utils.MyBatisUtil;

public class UserTest {
	
	private Logger logger=Logger.getLogger(UserTest.class);
	private SqlSession initSqlSession=null;
	
	@Before
	public void init(){
		initSqlSession=MyBatisUtil.getSqlSession();
	}


	@Test
	public void selectCounttest() {
		String resource="mybatis-config.xml";
		int count=0;
		SqlSession sqlSession=null;
		try {
			//读取配置文件
			InputStream is=Resources.getResourceAsStream(resource);
			//创建sqlsessionfactory对象
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
			//创建sqlsession
			sqlSession=sqlSessionFactory.openSession();
			//调用Mapper文件进行数据操作（要将Mapper加入到mybatis-configuration.xml中）
			count=sqlSession.selectOne("dao.UserMapper.count");
			logger.info("数据库中共有"+count+"条记录");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (sqlSession!=null) {
				sqlSession.close();
			}
		}
		Assert.assertEquals(9, count);
	}
	
	@Test
	public void testadd(){
		User user=new User();
		user.setUserName("韩云溪");
		user.setUserCode("hanyunxi");
		user.setUserPassword("12456");
		SqlSession sqlSession=MyBatisUtil.getSqlSession();
		int i=sqlSession.insert("dao.UserMapper.add",user);
		sqlSession.commit();
		MyBatisUtil.closeSqlSession(sqlSession);
		logger.debug("共有"+i+"行发生了变化");
	}
	
	@Test
	public void updateTest(){
		User user=new User();
		user.setId(26);
		user.setUserCode("war");
		user.setUserName("战争之王");
		user.setUserPassword("12344");
		SqlSession session=MyBatisUtil.getSqlSession();
		session.getMapper(UserMapper.class).update(user);
	}
	
	@Test
	public void getUserListTest(){
		Role role=new Role();
		role.setId(1);
		List<User> userList=initSqlSession.getMapper(UserMapper.class).getUserListByRoleId(role);
		for (User user : userList) {
			logger.info("用户名为"+user.getUserName()+"-========"+"所属部门为"+user.getRoleName());
		}
	}
	
	@Test
	public void updateUserByInfoTest(){
		User user=new User();
		user.setId(3);
		user.setUserName("逯芳竹");
		initSqlSession.getMapper(UserMapper.class).updateUserInfo(user);
		
	}
}
