package xyz.ligh.ds.multidb_dynamic_datasource.model.db2;

public class Db2UserInfo {
    private Long id = 0L;
    private String user_name = "";
    private String user_pass = "";
    private String user_type = "";
    private String user_name_cn = "";
    private String user_img = "";
    private String user_email = "";
    private String user_tel = "";
    private String user_status = "";
    private String user_create_time = "";
    private String user_expire_time = "";
    private String user_lock_time = "";
    private String user_pass_set_time = "";
    private int try_times = 0;
    private String last_try_time = "";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_name_cn() {
        return user_name_cn;
    }

    public void setUser_name_cn(String user_name_cn) {
        this.user_name_cn = user_name_cn;
    }

    public String getUser_img() {
        return user_img;
    }

    public void setUser_img(String user_img) {
        this.user_img = user_img;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(String user_create_time) {
        this.user_create_time = user_create_time;
    }

    public String getUser_expire_time() {
        return user_expire_time;
    }

    public void setUser_expire_time(String user_expire_time) {
        this.user_expire_time = user_expire_time;
    }

    public String getUser_lock_time() {
        return user_lock_time;
    }

    public void setUser_lock_time(String user_lock_time) {
        this.user_lock_time = user_lock_time;
    }

    public String getUser_pass_set_time() {
        return user_pass_set_time;
    }

    public void setUser_pass_set_time(String user_pass_set_time) {
        this.user_pass_set_time = user_pass_set_time;
    }

    public int getTry_times() {
        return try_times;
    }

    public void setTry_times(int try_times) {
        this.try_times = try_times;
    }

    public String getLast_try_time() {
        return last_try_time;
    }

    public void setLast_try_time(String last_try_time) {
        this.last_try_time = last_try_time;
    }

    public String toString(){
        return String.format("%d-%s",id,user_name);
    }
}
