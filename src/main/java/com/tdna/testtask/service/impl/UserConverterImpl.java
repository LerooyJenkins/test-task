package com.tdna.testtask.service.impl;

import com.tdna.testtask.domain.LevelResultParameter;
import com.tdna.testtask.domain.UserResultParameter;
import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.service.UserConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserConverterImpl implements UserConverter {

    @Override
    public List<UserFullInfoDto> convertTopUserResultsToDtoList(List<UserResultParameter> topUserResults) {
        return topUserResults.stream()
                .map(userResultParameter -> new UserFullInfoDto(userResultParameter.getUserId(), userResultParameter.getLevelId(), userResultParameter.getResult()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserFullInfoDto> convertTopLevelResultsToDtoList(List<LevelResultParameter> topLevelResults) {
        return topLevelResults.stream()
                .map(levelResultParameter -> new UserFullInfoDto(levelResultParameter.getUserId(), levelResultParameter.getLevelId(), levelResultParameter.getResult()))
                .collect(Collectors.toList());
    }

}
