package com.tdna.testtask.repository;

import com.tdna.testtask.entity.UserFullInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserFullInfo, Long> {

    @Query(value = "select * from user_full_info where user_id = ?1 order by result desc, level_id desc limit 20", nativeQuery = true)
    List<UserFullInfo> findUserResultsByUserId(Long userId);

    @Query(value = "select * from user_full_info where level_id = ?1 order by result desc, user_id desc limit 20", nativeQuery = true)
    List<UserFullInfo> findUsersResultsByLevelId(Long levelId);

}
