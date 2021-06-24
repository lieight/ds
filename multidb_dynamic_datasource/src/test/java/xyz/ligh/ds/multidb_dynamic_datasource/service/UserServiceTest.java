package xyz.ligh.ds.multidb_dynamic_datasource.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.ligh.ds.multidb_dynamic_datasource.model.db1.Db1UserInfo;
import xyz.ligh.ds.multidb_dynamic_datasource.model.db2.Db2UserInfo;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    private static Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    UserService userService;

    @Test
    public void test(){
        Long db1_user_id = 1L;

        List<Db1UserInfo> db1UserInfoList = userService.getDb1UserInfoList(db1_user_id);

        Long db2_user_id = 0L;

        List<Db2UserInfo> db2UserInfoList = userService.getDb2UserInfoList(db2_user_id);

        System.out.println("======================================================");
        for(Db1UserInfo x:db1UserInfoList){
            System.out.println(x.toString());
        }
        System.out.println("======================================================");
        for(Db2UserInfo x:db2UserInfoList){
            System.out.println(x.toString());
        }
        System.out.println("======================================================");
    }
}
