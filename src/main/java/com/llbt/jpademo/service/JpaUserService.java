package com.llbt.jpademo.service;

import com.llbt.jpademo.entity.JpaUser;

import java.util.List;

public interface JpaUserService {
    /**
     * 新增用户
     * @param user 用户对象
     */
    JpaUser insertUser(JpaUser user);

    /**
     * 删除用户
     * @param id 删除id
     */
    void deleteUser(Long id);

    /**
     * 修改用户
     * @param user 用户信息
     */
    JpaUser updateUser(JpaUser user);

    /**
     * 查询所有用户
     */
    List<JpaUser> findAllUser();

    /**
     * 通过id查询用户
     * @param id 用户id
     */
    JpaUser findUserById(Long id);

    Long findCount();
    /**
     *  使用原生SQL查询
     */
    Long findCountBySql();


    Long findCountByHql(String name,String createBy);
}

