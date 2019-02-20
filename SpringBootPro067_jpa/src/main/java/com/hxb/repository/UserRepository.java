package com.hxb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hxb.entity.User;

/*集成JpaRepository来完成对数据库的操作*/
public interface UserRepository extends JpaRepository<User, Integer> {

}









































