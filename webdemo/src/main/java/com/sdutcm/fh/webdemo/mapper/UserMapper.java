package com.sdutcm.fh.webdemo.mapper;


import com.sdutcm.fh.webdemo.entities.Employee;
import com.sdutcm.fh.webdemo.entities.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from employee")
    public List<Employee> findAllemp();

    @Delete("delete from employee where id = #{id}")
    public int deleteByID(int id);

    @Select("select * from user1 where username = #{username}")
    public User findUserByID(String username);

    @Insert("insert into employee(id,lastName,email,gender,department,birth) values(#{id},#{lastName},#{email},#{gender},#{department},#{birth})")
    public int addUser(Employee employee);

    @Insert("insert into user1(username,password) values (#{param1},#{param2})")
    public int addinsert(String username, String password);

    @Select("select * from user1 where username = #{param1} and password = #{param2}")
    public User findByiP(String username, String password);


}
