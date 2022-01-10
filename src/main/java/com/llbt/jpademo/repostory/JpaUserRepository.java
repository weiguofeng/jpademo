package com.llbt.jpademo.repostory;

import com.llbt.jpademo.entity.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface JpaUserRepository extends JpaRepository<JpaUser,Long>, JpaSpecificationExecutor<JpaUser> {

    /**
     * 原生的sql查询
     * @return
     */
    @Query(value = "select count(id) from jpa_user",nativeQuery = true)
    long findCountBySql();


    /**
     * HQL 的查询
     */
    @Query("SELECT count(u.id) from JpaUser u WHERE  u.name = :name AND u.createdBy = :createBy")
    Long findCountByHql(@Param("name") String name, @Param("createBy") String createBy);


}
