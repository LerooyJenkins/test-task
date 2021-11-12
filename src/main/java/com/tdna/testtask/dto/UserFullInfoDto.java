package com.tdna.testtask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserFullInfoDto {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("level_id")
    private Long levelId;

    private Long result;

    public UserFullInfoDto() {
    }

    public UserFullInfoDto(Long userId, Long levelId, Long result) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFullInfoDto that = (UserFullInfoDto) o;

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
        return "UserFullInfoDto{" +
                "userId=" + userId +
                ", levelId=" + levelId +
                ", result=" + result +
                '}';
    }
}
