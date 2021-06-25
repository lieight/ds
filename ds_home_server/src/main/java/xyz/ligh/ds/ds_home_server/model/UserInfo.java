package xyz.ligh.ds.ds_home_server.model;

import lombok.Data;

@Data
public class UserInfo {
    private Integer id;
    private String user_name;
    private String user_pass;
    private String user_status;
}
