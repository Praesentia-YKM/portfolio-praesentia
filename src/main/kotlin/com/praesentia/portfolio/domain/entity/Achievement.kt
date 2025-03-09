package com.praesentia.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achievement(
    title: String,
    description:String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    var id: Long? = null

    // @Column을 안 붙이면 알아서 db에 카멜케이스->스네이크 케이스 매핑돼서 들어감
    var title: String = title

    var description: String = description

    var achievementDate: LocalDate? = achievedDate

    var host: String = host

    var isActive: Boolean = isActive

}