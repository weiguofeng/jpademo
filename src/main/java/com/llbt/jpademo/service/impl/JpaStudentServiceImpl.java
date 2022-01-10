package com.llbt.jpademo.service.impl;

import com.llbt.jpademo.entity.JpaStudent;
import com.llbt.jpademo.repostory.JpaStudentRepository;
import com.llbt.jpademo.service.JpaStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JpaStudentServiceImpl implements JpaStudentService {

    @Autowired
    private JpaStudentRepository jpaStudentRepository;

    @Override
    public JpaStudent insertUser(JpaStudent student) {
        return (JpaStudent) jpaStudentRepository.save(student);
    }

    @Override
    public void deleteUser(Long id) {
        jpaStudentRepository.deleteById(id);
    }

    @Override
    public JpaStudent updateUser(JpaStudent student) {
        return (JpaStudent) jpaStudentRepository.save(student);
    }

    @Override
    public List<JpaStudent> findAllUser() {
        return jpaStudentRepository.findAll();
    }

    @Override
    public JpaStudent findUserById(Long id) {
        return (JpaStudent) jpaStudentRepository.findById(id).orElse(null);
    }

    /**
     * 遇到的问题
     * @return
     */
    public Long findCount() {
//        无参数
        long count = jpaStudentRepository.count();

//        带参数的JpaRepository--CrudRepostory也沒有帶参数的count查询啊
        return count;
    }

    /**
     * 使用原生的sql查询
     * 自定义一个查询比如count
     */
    @Override
    public Long findCountBySql() {
        return jpaStudentRepository.findCountBySql();
    }

    /**
     * 使用HQL的查询
     */
    @Override
    public Long findCountByHql(String name,String createBy){
        return jpaStudentRepository.findCountByHql(name,createBy);
    }



}
