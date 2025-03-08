package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository

interface HttpInterfaceRepository: JpaRepository<HttpInterface, Long> {

}