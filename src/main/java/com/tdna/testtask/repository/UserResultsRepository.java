package com.tdna.testtask.repository;

import com.tdna.testtask.domain.UserResultParameter;
import com.tdna.testtask.dto.UserFullInfoDto;

import java.util.List;

public interface UserResultsRepository {
    List<UserResultParameter> findTopUserResults(Long userId);

    void addResult(UserFullInfoDto userFullInfoDto);
}
