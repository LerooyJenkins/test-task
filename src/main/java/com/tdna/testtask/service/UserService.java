package com.tdna.testtask.service;

import com.tdna.testtask.dto.UserFullInfoDto;

import java.util.List;

public interface UserService {

    List<UserFullInfoDto> findUserResultsByUserId(Long userId);

    List<UserFullInfoDto> findUsersResultsByLevelId(Long levelId);

    UserFullInfoDto addUserResult(UserFullInfoDto userFullInfoDto);

}
