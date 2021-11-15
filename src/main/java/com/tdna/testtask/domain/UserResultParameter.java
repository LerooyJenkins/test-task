package com.tdna.testtask.domain;

public class UserResultParameter extends AbstractResultParameter {

    public UserResultParameter(Long userId, Long levelId, Long result) {
        super(userId, levelId, result);
    }

    @Override
    public Long getKeyParameter() {
        return getUserId();
    }

    @Override
    public Long getFirstParameter() {
        return getResult();
    }

    @Override
    public Long getSecondParameter() {
        return getLevelId();
    }

}
