package com.llbt.jpademo.service.impl;

import com.llbt.jpademo.entity.JpaUser;
import com.llbt.jpademo.repostory.JpaUserRepository;
import com.llbt.jpademo.service.JpaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaUserServiceImpl implements JpaUserService {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @Override
    public JpaUser insertUser(JpaUser user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        jpaUserRepository.deleteById(id);
    }

    @Override
    public JpaUser updateUser(JpaUser user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public List<JpaUser> findAllUser() {
        return jpaUserRepository.findAll();
    }

    @Override
    public JpaUser findUserById(Long id) {
        return jpaUserRepository.findById(id).orElse(null);
    }

    /**
     * 遇到的问题
     * @return
     */
    public Long findCount() {
//        无参数
        long count = jpaUserRepository.count();

//        带参数的JpaRepository--CrudRepostory也沒有帶参数的count查询啊
        return count;
    }

    /**
     * 使用原生的sql查询
     * 自定义一个查询比如count
     */
    @Override
    public Long findCountBySql() {
        return jpaUserRepository.findCountBySql();
    }

    /**
     * 使用HQL的查询
     */
    @Override
    public Long findCountByHql(String name,String createBy){
        return jpaUserRepository.findCountByHql(name,createBy);
    }



}
