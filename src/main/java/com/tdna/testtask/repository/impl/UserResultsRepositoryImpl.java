package com.tdna.testtask.repository.impl;

import com.tdna.testtask.domain.ResultParameter;
import com.tdna.testtask.domain.UserResultParameter;
import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.repository.ResultProcessor;
import com.tdna.testtask.repository.UserResultsRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

@Component
public class UserResultsRepositoryImpl extends ResultProcessor implements UserResultsRepository {

    private final Map<Long, CopyOnWriteArraySet<ResultParameter>> userIdToUserResults = new ConcurrentHashMap<>();

    @Override
    public List<UserResultParameter> findTopUserResults(Long userId) {
        if (!userIdToUserResults.containsKey(userId)) {
            return Collections.emptyList();
        }

        return userIdToUserResults.get(userId).stream()
                .sorted(createResultParameterComparator())
                .map(this::createUserResultParameter)
                .collect(Collectors.toList());
    }

    private UserResultParameter createUserResultParameter(ResultParameter resultParameter) {
        return new UserResultParameter(resultParameter.getKeyParameter(), resultParameter.getSecondParameter(), resultParameter.getFirstParameter());
    }

    @Override
    public void addResult(UserFullInfoDto userFullInfoDto) {
        UserResultParameter newUserResultParameter = new UserResultParameter(
                userFullInfoDto.getUserId(),
                userFullInfoDto.getLevelId(),
                userFullInfoDto.getResult()
        );

        processAddResult(userIdToUserResults, newUserResultParameter);
    }
}
