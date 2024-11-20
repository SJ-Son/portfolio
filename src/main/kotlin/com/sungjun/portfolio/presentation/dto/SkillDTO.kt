package com.sungjun.portfolio.presentation.dto

import com.sungjun.portfolio.domain.entity.Skill

data class SkillDTO(
    val name: String,
    val type: String
) {
    constructor(skill: Skill) : this(skill.name, skill.type.name)
}