package com.tdna.testtask.controller;

import com.tdna.testtask.dto.UserFullInfoDto;
import com.tdna.testtask.service.UserService;
import com.tdna.testtask.service.UserValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserValidator userValidator;

    private final UserService userService;

    public UserController(UserValidator userValidator,
                          UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @GetMapping("/userinfo/{user_id}")
    public ResponseEntity<?> findUserInfo(@PathVariable(value = "user_id") Long userId) {
        return ResponseEntity
                .status(200)
                .body(userService.findUserResultsByUserId(userId));
    }

    @GetMapping("/levelinfo/{level_id}")
    public ResponseEntity<?> findLevelInfo(@PathVariable(value = "level_id") Long levelId) {
        return ResponseEntity
                .status(200)
                .body(userService.findUsersResultsByLevelId(levelId));
    }

    @PutMapping("/setinfo")
    public ResponseEntity<?> addUserInfo(@RequestBody UserFullInfoDto userFullInfoDto) {

        if (!userValidator.isUserFullInfoDtoValidate(userFullInfoDto)) {
            return ResponseEntity
                    .status(400)
                    .body("One parameter in dto is null - " + userFullInfoDto);
        }

        userService.addUserResult(userFullInfoDto);

        return ResponseEntity
                .status(200)
                .build();
    }

    // add for tests
    @PutMapping("/setinfo-arr")
    public ResponseEntity<?> addUserInfoArr(@RequestBody List<UserFullInfoDto> userFullInfoDtoList) {
        userService.addUserResults(userFullInfoDtoList);

        return ResponseEntity
                .status(200)
                .build();
    }

}
