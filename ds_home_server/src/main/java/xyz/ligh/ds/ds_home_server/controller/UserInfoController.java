package xyz.ligh.ds.ds_home_server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ligh.ds.ds_home_server.model.UserInfo;
import xyz.ligh.ds.ds_home_server.service.UserInfoService;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
@Api(value = "用户类" ,tags = "用户操作接口")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(value = "/findUserInfoList")
    @ApiOperation(value="获取用户列表", notes="获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = false, paramType = "query")
    })
    public List<UserInfo> findUserInfoList(String id){
        return userInfoService.findUserInfoList(id);
    }
}
