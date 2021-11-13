package com.tdna.testtask.domain;

public abstract class AbstractResultParameter implements ResultParameter {

    private Long userId;

    private Long levelId;

    private Long result;

    public AbstractResultParameter() {
    }

    public AbstractResultParameter(Long userId, Long levelId, Long result) {
        this.userId = userId;
        this.levelId = levelId;
        this.result = result;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

    @Override
    public abstract Long getKeyParameter();

    @Override
    public abstract Long getFirstParameter();

    @Override
    public abstract Long getSecondParameter();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();

    @Override
    public String toString() {
        return "AbstractResultParameter{" +
                "userId=" + userId +
                ", levelId=" + levelId +
                ", result=" + result +
                '}';
    }
}
