package xyz.ligh.ds.ds_home_server.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class UserInfoMapper {
    public String findUserInfoList(String id){
        SQL sql = new SQL();
        sql.SELECT("id,user_name,user_pass,user_status");
        sql.FROM("user_info");
        if(!StringUtils.isEmpty(id)){
            sql.WHERE("id=#{id}");
        }
        return sql.toString();
    }
}
