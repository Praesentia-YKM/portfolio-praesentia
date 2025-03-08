package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository: JpaRepository<Project, Long> {

}