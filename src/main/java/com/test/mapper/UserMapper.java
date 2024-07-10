package com.test.mapper;
import com.test.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    String username(String username);
    int id(Integer id);
    String password(String password);
    User getUserByName(String username);
    @Insert("insert into users (username,password) values (#{username},#{password})")
    Integer insert(User user);
    @Select({"select role_id from t_user where username = #{username}"})
    Integer getRoles(String username);
    @Select({"select permissionname from t_permission where  role_id = #{role_id}"})
    String getPermissions(Integer role_id);
    @Select({"select id,username,password from t_user where username = #{username}"})
    User getuserByUsername(String username);

}
