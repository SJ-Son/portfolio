package com.sungjun.portfolio.domain.repository

import com.sungjun.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository : JpaRepository<Project, Long>