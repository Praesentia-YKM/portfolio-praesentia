package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface HttpInterfaceRepository : JpaRepository<HttpInterface, Long> {

    /* Spring Data JPA는 Repository 인터페이스의 메서드명을 기반으로 엔터티의 필드를 예측하고 자동으로 쿼리를 생성합니다.
       즉, 메서드명에서 createdDateTime을 사용했다면, JPA는 HttpInterface 엔터티에 createdDateTime이라는 필드가 존재한다고 가정합니다. */

    /* countAllBy → 모든 개수를 세는 쿼리 (SELECT COUNT)
       CreatedDateTimeBetween → createdDateTime 필드의 값이 특정 구간(Between)에 있는 데이터를 검색 */
    fun countAllByCreatedDateTimeBetween(start: LocalDateTime, end: LocalDateTime): Long

}