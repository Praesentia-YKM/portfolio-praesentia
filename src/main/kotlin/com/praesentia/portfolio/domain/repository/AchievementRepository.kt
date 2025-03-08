package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository

interface AchievementRepository: JpaRepository<Achievement, Long> {

}