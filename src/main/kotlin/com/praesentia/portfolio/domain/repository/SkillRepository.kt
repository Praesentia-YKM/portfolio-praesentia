package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository: JpaRepository<Skill, Long> {

}