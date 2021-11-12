package com.tdna.testtask.service.impl;

import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.service.UserValidator;
import org.springframework.stereotype.Service;

@Service
public class UserValidatorImpl implements UserValidator {

    @Override
    public boolean isUserFullInfoDtoValidate(UserFullInfoDto userFullInfoDto) {
        return userFullInfoDto.getUserId() != null && userFullInfoDto.getLevelId() != null && userFullInfoDto.getResult() != null; // or use @NotNull annotation
    }

}
