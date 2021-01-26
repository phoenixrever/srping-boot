package com.phoenixhell.boot.mapper;

import com.phoenixhell.boot.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author phoenixhell
 * @create 2021/1/14 0014-下午 3:19
 */

public interface UserMapper {
//    @Select("where") 不用xml映射 纯注解
     List<User> getUsers() ;
//     @Insert()
//     @Options(useGeneratedKeys =true,keyProperty = "id")
     User getUser(String id);
}
