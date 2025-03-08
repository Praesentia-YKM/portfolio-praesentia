package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository: JpaRepository<Experience, Long> {

}