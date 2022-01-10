package com.llbt.jpademo.controller;

import com.llbt.jpademo.entity.JpaStudent;
import com.llbt.jpademo.service.JpaStudentService;
import com.llbt.jpademo.service.JpaStudentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class JpaStudentController {
    @Resource
    private JpaStudentService jpaStudentService;

    /**
     * 新增学生
     */
    @PostMapping("")
    public JpaStudent addUser(@RequestBody JpaStudent user){
        return jpaStudentService.insertUser(user);
    }

    /**
     * 删除学生
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        jpaStudentService.deleteUser(id);
    }

    /**
     * 修改学生
     */
    @PutMapping("")
    public JpaStudent updateUser(@RequestBody JpaStudent user){
        return jpaStudentService.updateUser(user);
    }

    /**
     * 全查学生
     */
    @GetMapping("")
    public List<JpaStudent> findAll(){
        return jpaStudentService.findAllUser();
    }

    /**
     * id查学生
     */
    @GetMapping("/{id}")
    public JpaStudent findbyId(@PathVariable("id") Long id){
        return jpaStudentService.findUserById(id);
    }


    /**
     * count的问题
     * @return
     */
    @GetMapping("/count1")
    public Long findCount1(){
        return jpaStudentService.findCount();
    }

    /**
     * count的问题
     * @return
     */
    @GetMapping("/count2")
    public Long findCount2(){
        return jpaStudentService.findCountBySql();
    }


    /**
     * count的问题
     * @return
     */
    @GetMapping("/count3/{name}/{createBy}")
    public Long findCount3(@PathVariable("name") String name, @PathVariable("createBy") String createBy){
        return jpaStudentService.findCountByHql(name,createBy);
    }






}

