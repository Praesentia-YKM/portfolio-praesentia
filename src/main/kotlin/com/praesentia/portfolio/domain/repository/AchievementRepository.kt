package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AchievementRepository : JpaRepository<Achievement, Long> {

    // select * from achievement where is_active = :isActive
    fun findAllByIsActive(isActive: Boolean): List<Achievement>

}