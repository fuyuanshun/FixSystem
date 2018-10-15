package com.fys.fixsystem.dao;

import com.fys.fixsystem.pojo.UInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ReqDao {

    /**
     * 管理员账户是否存在
     * @param name
     * @param password
     * @return
     */
    @Select("select * from f_admin where name = #{name} and password = #{password}")
    Boolean isExist(@Param("name")String name, @Param("password")String password);

    /**
     * 注册管理员账户
     */
    @Insert("insert into f_admin (name, password) values (#{name}, #{password})")
    int addAdmin(@Param("name")String name, @Param("password")String password);

    /**
     * 将用户反馈的信息插入到数据库
     */
    @Insert("insert into uinfo (name, floor, room, phone, info, createDate) values (#{name}, #{floor}, #{room}, #{phone}, #{info}, #{createDate})")
    int addInfo(UInfo uInfo);

    /**
     * 分页查询
     */
    @Select("select * from uinfo limit #{start}, #{pageSize}")
    List<UInfo> getInfos(@Param("start")Integer start, @Param("pageSize")Integer pageSize);

    /**
     * 查询数据库有多少条故障信息
     */
    @Select("select count(id) from uinfo")
    int selectCount();

    @Delete("delete from uinfo where id = #{id}")
    int deleteById(String id);
}