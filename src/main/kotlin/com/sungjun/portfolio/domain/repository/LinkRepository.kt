package com.sungjun.portfolio.domain.repository

import com.sungjun.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository : JpaRepository<Link, Long>