package com.praesentia.portfolio.domain.repository

import com.praesentia.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository: JpaRepository<Link, Long> {

}