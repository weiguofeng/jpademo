package com.llbt.jpademo.service;

import com.llbt.jpademo.entity.JpaStudent;
import com.llbt.jpademo.entity.JpaStudent;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JpaStudentService {
    /**
     * 新增用户
     * @param user 用户对象
     */
    JpaStudent insertUser(JpaStudent user);

    /**
     * 删除用户
     * @param id 删除id
     */
    void deleteUser(Long id);

    /**
     * 修改用户
     * @param user 用户信息
     */
    JpaStudent updateUser(JpaStudent user);

    /**
     * 查询所有用户
     */
    List<JpaStudent> findAllUser();

    /**
     * 通过id查询用户
     * @param id 用户id
     */
    JpaStudent findUserById(Long id);

    Long findCount();
    /**
     *  使用原生SQL查询
     */
    Long findCountBySql();


    Long findCountByHql(String name, String createBy);
}

