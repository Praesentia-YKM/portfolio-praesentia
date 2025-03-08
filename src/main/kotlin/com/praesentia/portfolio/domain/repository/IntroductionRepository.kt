package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository: JpaRepository<Introduction, Long> {

}