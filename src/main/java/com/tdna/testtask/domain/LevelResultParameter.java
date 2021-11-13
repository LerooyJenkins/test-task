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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractResultParameter that = (AbstractResultParameter) o;

        if (getUserId() != null ? !getUserId().equals(that.getUserId()) : that.getUserId() != null) return false;
        return getResult() != null ? getResult().equals(that.getResult()) : that.getResult() == null;
    }

    @Override
    public int hashCode() {
        int result1 = getUserId() != null ? getUserId().hashCode() : 0;
        result1 = 31 * result1 + (getResult() != null ? getResult().hashCode() : 0);
        return result1;
    }
}
