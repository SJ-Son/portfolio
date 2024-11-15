package com.sungjun.portfolio.domain.repository

import com.sungjun.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository : JpaRepository<Skill, Long>