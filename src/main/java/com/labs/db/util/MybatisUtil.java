package com.labs.db.util;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisUtil {

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;

    private MybatisUtil() {
    }

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.cfg.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = threadLocal.get();
        if (null == sqlSession) {
            sqlSession = sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void closeSession() {
        SqlSession sqlSession = threadLocal.get();
        if (null != sqlSession) {
            sqlSession.close();
            threadLocal.remove();
        }
    }

    public static void main(String[] args) throws Exception {
        Connection con = MybatisUtil.getSqlSession().getConnection();
        System.out.println(null == con ? "Get Connection Fail..." : "Get Connection Success...");
		
		/*
		StudentDao dao = new StudentDao();
		Map<String,Object> params = new HashMap();
		params.put("school","XMU");
		params.put("ids", new Integer[]{1,2,3});
		List<Student> studentList = dao.findByIds(params)*/
        ;
    }
}
