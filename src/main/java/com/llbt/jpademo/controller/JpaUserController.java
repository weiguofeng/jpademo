package com.llbt.jpademo.controller;

import com.llbt.jpademo.entity.JpaUser;
import com.llbt.jpademo.service.JpaUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class JpaUserController {
    @Resource
    private JpaUserService jpaUserService;

    /**
     * 新增用户
     */
    @PostMapping("")
    public JpaUser addUser(@RequestBody JpaUser user){
        return jpaUserService.insertUser(user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        jpaUserService.deleteUser(id);
    }

    /**
     * 修改用户
     */
    @PutMapping("")
    public JpaUser updateUser(@RequestBody JpaUser user){
        return jpaUserService.updateUser(user);
    }

    /**
     * 全查用户
     */
    @GetMapping("")
    public List<JpaUser> findAll(){
        return jpaUserService.findAllUser();
    }

    /**
     * id查用户
     */
    @GetMapping("/{id}")
    public JpaUser findbyId(@PathVariable("id") Long id){
        return jpaUserService.findUserById(id);
    }


    /**
     * count的问题
     * @return
     */
    @GetMapping("/count1")
    public Long findCount1(){
        return jpaUserService.findCount();
    }

    /**
     * count的问题
     * @return
     */
    @GetMapping("/count2")
    public Long findCount2(){
        return jpaUserService.findCountBySql();
    }


    /**
     * count的问题
     * @return
     */
    @GetMapping("/count3/{name}/{createBy}")
    public Long findCount3(@PathVariable("name") String name, @PathVariable("createBy") String createBy){
        return jpaUserService.findCountByHql(name,createBy);
    }






}

