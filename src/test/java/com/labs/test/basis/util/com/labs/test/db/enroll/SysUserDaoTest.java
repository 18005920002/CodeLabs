package com.labs.test.basis.util.com.labs.test.db.enroll;

import com.alibaba.fastjson.JSON;
import com.labs.db.dao.SysUserDao;
import org.testng.annotations.Test;

/**
 * @author win10
 * @Description
 * @Date 2018/9/30 09:49
 */
public class SysUserDaoTest {

    @Test
    public void getSysUser() {
        System.out.println(JSON.toJSONString(new SysUserDao().getSysUserById("1001")));
    }
}
