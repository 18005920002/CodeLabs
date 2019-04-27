package com.labs.dictionary.dao;

import com.labs.db.util.MybatisUtil;
import com.labs.dictionary.vo.ColumnVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 数据字典DAO
 *
 * @author tanyun.zheng
 * @version v1.0 2019/4/2 13:40
 */
public class DictionaryDao {

    SqlSession session = MybatisUtil.getSqlSession();
    //public List<ColumnVO> getColumns(String tableName){
    //    return this.queryForList(sqlXml+"getColumns",tableName);
    //}

    public List<ColumnVO> getColumns(String tableName){
        List<ColumnVO> columnVO =  session.selectList("db.enroll.sys.DictionaryMapper.listColumns", tableName);
        return columnVO;
    }

}
