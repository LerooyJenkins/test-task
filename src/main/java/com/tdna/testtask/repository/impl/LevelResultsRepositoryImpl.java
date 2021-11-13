package com.tdna.testtask.repository.impl;

import com.tdna.testtask.domain.LevelResultParameter;
import com.tdna.testtask.domain.ResultParameter;
import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.repository.LevelResultsRepository;
import com.tdna.testtask.repository.ResultProcessor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import static java.util.stream.Collectors.toList;

@Component
public class LevelResultsRepositoryImpl extends ResultProcessor implements LevelResultsRepository {

    private final Map<Long, CopyOnWriteArraySet<ResultParameter>> levelIdToUsersResults = new ConcurrentHashMap<>();

    @Override
    public List<LevelResultParameter> findTopLevelResults(Long levelId) {
        if (!levelIdToUsersResults.containsKey(levelId)) {
            return Collections.emptyList();
        }

        return levelIdToUsersResults.get(levelId).stream()
                .sorted(createResultParameterComparator())
                .map(this::createLevelResultParameter)
                .collect(toList());
    }

    private LevelResultParameter createLevelResultParameter(ResultParameter resultParameter) {
        return new LevelResultParameter(resultParameter.getSecondParameter(), resultParameter.getKeyParameter(), resultParameter.getFirstParameter());
    }

    @Override
    public void addResult(UserFullInfoDto userFullInfoDto) {
        LevelResultParameter newLevelResultParameter = new LevelResultParameter(
                userFullInfoDto.getUserId(),
                userFullInfoDto.getLevelId(),
                userFullInfoDto.getResult()
        );

        processAddResult(levelIdToUsersResults, newLevelResultParameter);
    }
}
