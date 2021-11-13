package com.tdna.testtask.repository;

import com.tdna.testtask.domain.LevelResultParameter;
import com.tdna.testtask.dto.UserFullInfoDto;

import java.util.List;

public interface LevelResultsRepository {
    List<LevelResultParameter> findTopLevelResults(Long levelId);

    void addResult(UserFullInfoDto userFullInfoDto);
}
