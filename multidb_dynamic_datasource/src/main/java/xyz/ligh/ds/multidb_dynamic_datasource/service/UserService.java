package xyz.ligh.ds.multidb_dynamic_datasource.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ligh.ds.multidb_dynamic_datasource.dao.db1.Db1UserInfoDao;
import xyz.ligh.ds.multidb_dynamic_datasource.dao.db2.Db2UserInfoDao;
import xyz.ligh.ds.multidb_dynamic_datasource.model.db1.Db1UserInfo;
import xyz.ligh.ds.multidb_dynamic_datasource.model.db2.Db2UserInfo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private Db1UserInfoDao db1UserInfoDao;
    @Autowired
    private Db2UserInfoDao db2UserInfoDao;

    /**
     * 通过 @DS 注解指定使用 DB1 数据库，查询用户信息
     * @param id 主键ID
     * @return 用户信息
     */
    @DS("db1")
    public List<Db1UserInfo> getDb1UserInfoList(Long id){
        List<Db1UserInfo> infoList = null;
        try{
            infoList = db1UserInfoDao.selectById(id);
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(String.format("X   ,UserService,findDb1UserInfo,exception:%s",ex.getMessage()));
        }
        if(infoList == null){
            infoList = new ArrayList<>();
        }
        return infoList;
    }

    /**
     * 通过 @DS 注解指定使用 DB2 数据库，查询账户数据
     * @param id 主键ID
     * @return 账户数据
     */
    @DS("db2")
    public List<Db2UserInfo> getDb2UserInfoList(Long id){
        List<Db2UserInfo> infoList = null;
        try{
            infoList = db2UserInfoDao.selectById(id);
        }catch (Exception ex){
            ex.printStackTrace();
            logger.error(String.format("X   ,UserService,findDb2UserInfo,exception:%s",ex.getMessage()));
        }
        if(infoList == null){
            infoList = new ArrayList<>();
        }
        return infoList;
    }
}
