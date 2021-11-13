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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractResultParameter that = (AbstractResultParameter) o;

        if (getLevelId() != null ? !getLevelId().equals(that.getLevelId()) : that.getLevelId() != null) return false;
        return getResult() != null ? getResult().equals(that.getResult()) : that.getResult() == null;
    }

    @Override
    public int hashCode() {
        int result1 = getLevelId() != null ? getLevelId().hashCode() : 0;
        result1 = 31 * result1 + (getResult() != null ? getResult().hashCode() : 0);
        return result1;
    }

}
