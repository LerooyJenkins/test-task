package com.tdna.testtask.service.impl;

import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.entity.UserFullInfo;
import com.tdna.testtask.service.UserConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserConverterImpl implements UserConverter {

    @Override
    public List<UserFullInfoDto> convertToUserFullInfoDtoList(List<UserFullInfo> userFullInfoList) {
        return userFullInfoList.stream()
                .map(this::convertToUserFullInfoDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserFullInfoDto convertToUserFullInfoDto(UserFullInfo userFullInfo) {
        return new UserFullInfoDto(
                userFullInfo.getUserId(),
                userFullInfo.getLevelId(),
                userFullInfo.getResult()
        );
    }

    @Override
    public UserFullInfo convertToUserFullInfo(UserFullInfoDto userFullInfoDto) {
        return new UserFullInfo(
                userFullInfoDto.getUserId(),
                userFullInfoDto.getLevelId(),
                userFullInfoDto.getResult()
        );
    }
}
