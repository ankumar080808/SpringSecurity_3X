package com.anant.com.anant.Spring_Security_3X.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anant.com.anant.Spring_Security_3X.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String username);

}
