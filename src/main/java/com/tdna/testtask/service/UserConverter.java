package com.tdna.testtask.service;

import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.entity.UserFullInfo;

import java.util.List;

public interface UserConverter {

    List<UserFullInfoDto> convertToUserFullInfoDtoList(List<UserFullInfo> userFullInfoList);

    UserFullInfoDto convertToUserFullInfoDto(UserFullInfo userFullInfo);

    UserFullInfo convertToUserFullInfo(UserFullInfoDto userFullInfoDto);

}
