package com.labs.db.dao;

import com.labs.db.po.SysUser;
import com.labs.db.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @Description
 * @author win10
 * @Date 2018/9/28 17:17
 */
public class SysUserDao {

    public SysUser getSysUserById(String id){
        SqlSession session = MybatisUtil.getSqlSession();
        SysUser sysUser = (SysUser) session.selectOne("db.enroll.sys.SysUserMapper.selectSysUser", id);
        return sysUser;
    }
}
