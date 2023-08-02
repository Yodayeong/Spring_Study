package dev.yoda.jpa.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;

@MappedSuperclass //모든 entity들이 가져야 할 속성 정의
@EntityListeners(AuditingEntityListener.class)
//추상 class
public abstract class BaseEntity {
    //처음 생성 시간
    @CreatedDate
    @Column(updatable = false)
    private Instant createdAt;

    //마지막 갱신 시간
    @LastModifiedDate
    @Column(updatable = true)
    private Instant updatedAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
