package com.tdna.testtask.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "user_full_info")
public class UserFullInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_full_info_sequence")
    @SequenceGenerator(name = "user_full_info_sequence", sequenceName = "user_full_info_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "level_id")
    private Long levelId;

    @Column(name = "result")
    private Long result;

    public UserFullInfo() {
    }

    public UserFullInfo(Long userId, Long levelId, Long result) {
        this.userId = userId;
        this.levelId = levelId;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

        UserFullInfo that = (UserFullInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (levelId != null ? !levelId.equals(that.levelId) : that.levelId != null) return false;
        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = id != null ? id.hashCode() : 0;
        result1 = 31 * result1 + (userId != null ? userId.hashCode() : 0);
        result1 = 31 * result1 + (levelId != null ? levelId.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }

    @Override
    public String toString() {
        return "UserFullInfo{" +
                "id=" + id +
                ", userId=" + userId +
                ", levelId=" + levelId +
                ", result=" + result +
                '}';
    }
}
