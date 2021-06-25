package xyz.ligh.ds.ds_home_server.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import xyz.ligh.ds.ds_home_server.mapper.UserInfoMapper;
import xyz.ligh.ds.ds_home_server.model.UserInfo;

import java.util.List;

@Mapper
@Component
public interface IUserInfoDao {
    @SelectProvider(type = UserInfoMapper.class,method = "findUserInfoList")
    List<UserInfo> findUserInfoList(String id);
}
