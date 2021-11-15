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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractResultParameter that = (AbstractResultParameter) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (levelId != null ? !levelId.equals(that.levelId) : that.levelId != null) return false;
        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = userId != null ? userId.hashCode() : 0;
        result1 = 31 * result1 + (levelId != null ? levelId.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "AbstractResultParameter{" +
                "userId=" + userId +
                ", levelId=" + levelId +
                ", result=" + result +
                '}';
    }
}
