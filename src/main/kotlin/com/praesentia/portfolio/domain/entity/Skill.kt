package com.praesentia.portfolio.domain.entity

import com.praesentia.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
    name: String,
    type: String,
    isActive: Boolean
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null

    var name: String = name

    // 예약어나, 흔한 명칭이 있을 수 있으니까 별도의 컬럼 이름 매핑을 해주고 코틀린 상에서 변수는 type으로 쓴다
    @Column(name = "skill_type") //
    // enum의 생성된 순서를 넣냐(LANGUAGE는 1, DATABASE는 2) , enum의 name을 넣냐 설정
    // 기본값인 숫자로 넣는건 ENUM의 순서가 도중에 바뀌면 정합성 문제가 생기고, 가독성도 딸리므로 ENUM은 무조건 타입 string으로 넣자.
    @Enumerated(value = EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type)

    var isActive: Boolean = isActive
}