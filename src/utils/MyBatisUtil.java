package utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	
	//获得sqlsessionfactory对象用于创建sqlsession,factory只需要创建一次。
	static{//静态代码块下，factory只会被创建一次
		try {
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			factory=new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//通过工厂获得sqlSession对象
	public static SqlSession getSqlSession() {
		return factory.openSession();
	}
	
	public static void closeSqlSession(SqlSession session) {
		if (session!=null) {
			session.close();
		}
	}

}
