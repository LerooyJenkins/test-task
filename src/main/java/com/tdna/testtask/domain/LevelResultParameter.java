package com.tdna.testtask.domain;

public class LevelResultParameter extends AbstractResultParameter{

    public LevelResultParameter(Long userId, Long levelId, Long result) {
        super(userId, levelId, result);
    }

    @Override
    public Long getKeyParameter() {
        return getLevelId();
    }

    @Override
    public Long getFirstParameter() {
        return getResult();
    }

    @Override
    public Long getSecondParameter() {
        return getUserId();
    }

}
