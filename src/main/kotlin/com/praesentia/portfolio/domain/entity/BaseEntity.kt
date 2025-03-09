package com.praesentia.portfolio.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity {

    @CreatedDate
    @Column(nullable = false, updatable = false)
    var createdDataTime: LocalDateTime = LocalDateTime.now()

    @LastModifiedDate // updatable의 기본값이 true라서 생략 가능
    @Column(nullable = false)
    var updatedDatetime: LocalDateTime = LocalDateTime.now()

}