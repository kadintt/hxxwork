package com.hxx.hxxwork.service;

import com.hxx.hxxwork.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    public Map querystu(Integer id);

    public List<Map> queryBj(Integer id);

    public List<Map> queryKc();

    void add(User user);

    void batchAdd(@Param("user")User user);

    void deleteStu(Integer sid);

    void deleteCours(Integer sid);

    List<User> queryStuList();
}
