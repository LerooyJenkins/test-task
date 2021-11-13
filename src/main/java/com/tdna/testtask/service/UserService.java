package com.tdna.testtask.service;

import com.tdna.testtask.dto.UserFullInfoDto;

import java.util.List;

public interface UserService {

    List<UserFullInfoDto> findUserResultsByUserId(Long userId);

    List<UserFullInfoDto> findUsersResultsByLevelId(Long levelId);

    void addUserResult(UserFullInfoDto userFullInfoDto);

    void addUserResults(List<UserFullInfoDto> userFullInfoDtoList);

}
