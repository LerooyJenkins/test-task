package com.tdna.testtask.service.impl;

import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.entity.UserFullInfo;
import com.tdna.testtask.repository.UserRepository;
import com.tdna.testtask.service.UserConverter;
import com.tdna.testtask.service.UserService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    private final UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository,
                           UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public List<UserFullInfoDto> findUserResultsByUserId(Long userId) {
        logger.info("Find user results by user id: " + userId);

        List<UserFullInfo> userResultsByUserId = userRepository.findUserResultsByUserId(userId);

        List<UserFullInfoDto> userResultsByUserIdDto = userConverter.convertToUserFullInfoDtoList(userResultsByUserId);

        logger.info("Successfully user results by user id: " + userId);

        return userResultsByUserIdDto;
    }

    @Override
    public List<UserFullInfoDto> findUsersResultsByLevelId(Long levelId) {
        logger.info("Find users results by level id: " + levelId);

        List<UserFullInfo> userResultsByLevelId = userRepository.findUsersResultsByLevelId(levelId);

        List<UserFullInfoDto> userResultsByLevelIdDto = userConverter.convertToUserFullInfoDtoList(userResultsByLevelId);

        logger.info("Successfully users results by level id: " + levelId);

        return userResultsByLevelIdDto;
    }

    @Override
    public UserFullInfoDto addUserResult(UserFullInfoDto userFullInfoDto) {
        logger.info("Add user result: " + userFullInfoDto);

        UserFullInfo userResult = userRepository.save(userConverter.convertToUserFullInfo(userFullInfoDto));

        logger.info("Successfully add user result: " + userResult);

        return userConverter.convertToUserFullInfoDto(userResult);
    }
}
