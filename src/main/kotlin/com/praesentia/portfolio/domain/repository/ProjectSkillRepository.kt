package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectSkillRepository: JpaRepository<ProjectSkill, Long> {

}