package com.tdna.testtask.service;

import com.tdna.testtask.domain.LevelResultParameter;
import com.tdna.testtask.domain.UserResultParameter;
import com.tdna.testtask.dto.UserFullInfoDto;

import java.util.List;

public interface UserConverter {
    List<UserFullInfoDto> convertTopUserResultsToDtoList(List<UserResultParameter> topUserResults);

    List<UserFullInfoDto> convertTopLevelResultsToDtoList(List<LevelResultParameter> topLevelResults);
}
