package com.test.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.test.entity.JsonResult;

@ApiModel(value = "用户实体类")

public class User2 {
    public User2(long id, String name, String password){
        this.id = id;
        this.username = name;
        this.password = password;
    }

    @ApiModelProperty(value="用户唯一标识")
    private long id;
    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
