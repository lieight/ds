package xyz.ligh.ds.ds_home_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ligh.ds.ds_home_server.dao.IUserInfoDao;
import xyz.ligh.ds.ds_home_server.model.UserInfo;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private IUserInfoDao iUserInfoDao;

    public List<UserInfo> findUserInfoList(String id){
        return iUserInfoDao.findUserInfoList(id);
    }
}
