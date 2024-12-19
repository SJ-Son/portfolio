package com.sungjun.portfolio.domain

import com.sungjun.portfolio.domain.constant.SkillType
import com.sungjun.portfolio.domain.entity.*
import com.sungjun.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val experienceRepository: ExperienceRepository,
    private val projectRepository: ProjectRepository,
    private val skillRepository: SkillRepository
) {
    @PostConstruct
    fun initializeData() {

        val achievements = mutableSetOf<Achievement>(
            Achievement(
                title = "title",
                description = "description",
                host = "host",
                achievedDate = LocalDate.of(2022, 1, 1),
                isActive = true
            ),
            Achievement(
                title = "title2",
                description = "description2",
                host = "host2",
                achievedDate = LocalDate.of(2022, 1, 1),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableSetOf<Introduction>(
            Introduction(content = "첫번째줄", isActive = true),
            Introduction(content = "두번째줄", isActive = true),
            Introduction(content = "세번째줄", isActive = true)
        )
        introductionRepository.saveAll(introductions)

        val links = mutableSetOf<Link>(
            Link(name = "link1", content = "http://www.link1.com", isActive = true),
            Link(name = "link2", content = "http://www.link2.com", isActive = true)
        )
        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "title1",
            description = "description1",
            startYear = 2009,
            startMonth = 1,
            endYear = 2009,
            endMonth = 2,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "학점?", isActive = true),
                ExperienceDetail(content = "동아리활동", isActive = true)
            )
        )

        val experience2 = Experience(
            title = "title2",
            description = "description2",
            startYear = 2019,
            startMonth = 1,
            endYear = 2019,
            endMonth = 2,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "회사", isActive = true),
                ExperienceDetail(content = "업무", isActive = true)
            )
        )
        experienceRepository.saveAll(mutableListOf(experience1, experience2))

        val java = Skill(name = "java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "mysql", type = SkillType.DATABASE.name, isActive = true)
        skillRepository.saveAll(mutableListOf(java, kotlin, spring, mysql))

        val project1 = Project(
            name = "project1",
            description = "description1",
            startYear = 2021,
            startMonth = 1,
            endYear = 2021,
            endMonth = 6,
            isActive = true
        )
        project1.addDetails(
            mutableListOf(
                ProjectDetail(content = "무슨기능개발", url = null, isActive = true),
                ProjectDetail(content = "개선이나 성능향상", url = null, isActive = true)
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
            )
        )

        val project2 = Project(
            name = "project2",
            description = "description1",
            startYear = 2021,
            startMonth = 1,
            endYear = 2021,
            endMonth = 6,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "무슨기능개발", url = null, isActive = true),
                ProjectDetail(content = "개선이나 성능향상", url = null, isActive = true),
                ProjectDetail(content = "Github Repository", url = "http://github.com", isActive = true),
            )
        )

        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = kotlin),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mysql),
            )
        )
        projectRepository.saveAll(mutableListOf(project1, project2))
    }
}