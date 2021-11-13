package com.tdna.testtask.service.impl;

import com.tdna.testtask.domain.LevelResultParameter;
import com.tdna.testtask.domain.UserResultParameter;
import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.repository.LevelResultsRepository;
import com.tdna.testtask.repository.UserResultsRepository;
import com.tdna.testtask.service.UserConverter;
import com.tdna.testtask.service.UserService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = getLogger(UserServiceImpl.class);

    private final UserResultsRepository userResultsRepository;

    private final LevelResultsRepository levelResultsRepository;

    private final UserConverter userConverter;

    public UserServiceImpl(UserResultsRepository userResultsRepository,
                           LevelResultsRepository levelResultsRepository,
                           UserConverter userConverter) {
        this.userResultsRepository = userResultsRepository;
        this.levelResultsRepository = levelResultsRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserFullInfoDto> findUserResultsByUserId(Long userId) {
        logger.info("Find user results by user id: " + userId);

        List<UserResultParameter> topUserResults = userResultsRepository.findTopUserResults(userId);

        List<UserFullInfoDto> userResultsByUserIdDto = userConverter.convertTopUserResultsToDtoList(topUserResults);

        logger.info("Successfully user results by user id: " + userId);

        return userResultsByUserIdDto;
    }

    @Override
    public List<UserFullInfoDto> findUsersResultsByLevelId(Long levelId) {
        logger.info("Find users results by level id: " + levelId);

        List<LevelResultParameter> topLevelResults = levelResultsRepository.findTopLevelResults(levelId);

        List<UserFullInfoDto> userResultsByLevelIdDto = userConverter.convertTopLevelResultsToDtoList(topLevelResults);

        logger.info("Successfully users results by level id: " + levelId);

        return userResultsByLevelIdDto;
    }

    @Override
    public void addUserResult(UserFullInfoDto userFullInfoDto) {
        logger.info("Add user result: " + userFullInfoDto);

        userResultsRepository.addResult(userFullInfoDto);

        levelResultsRepository.addResult(userFullInfoDto);

        logger.info("Successfully add user result: " + userFullInfoDto);
    }

    @Override
    public void addUserResults(List<UserFullInfoDto> userFullInfoDtoList) {
        userFullInfoDtoList.forEach(this::addUserResult);
    }
}
