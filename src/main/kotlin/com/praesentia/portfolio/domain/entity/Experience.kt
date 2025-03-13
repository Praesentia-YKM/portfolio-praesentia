package com.praesentia.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience(
    title: String,
    description: String,
    startYear: Int,
    startMonth: Int,
    endYear: Int?,
    endMonth: Int?,
    isActive: Boolean
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    var id: Long? = null

    var title: String = title

    var description: String = description

    var startYear: Int = startYear

    var startMonth: Int = startMonth

    var endYear: Int? = endYear

    var endMonth: Int? = startMonth

    var isActive: Boolean = isActive

    // jpa는 list로 N쪽 관계에 해당하는 데이터를 필드로 가져올 수 있다
    // ONE이 experiende , MANY가 ExperienceDetail
    // FetchType.EAGER : 부모와 자식을 쌍으로 움직이게 한다. db에서 부모만 꺼냈는데 자식까지 가져옴 (별로 좋은 방법 아님)
    //                   부모를 보고 자식까지 조회해야해서 부모의 수만큼 자식까지 N번 조회한다. 비효율적이다.
    // FetchType.LAZY : 부모를 조사하다가 부모에서 자식데이터가 필요할 때만 조회한다. (조금 더 효율적)
    @OneToMany(targetEntity = ExperienceDetail::class,
            fetch = FetchType.LAZY,
            cascade = [(CascadeType.ALL)])
    @JoinColumn(name = "experience_id")
    var details: MutableList<ExperienceDetail> = mutableListOf()

    fun getEndYearMonth(): String {
        if (endYear == null || endMonth == null) {
            return "Present"
        }

        return "${endYear}.${endMonth}"
    }

    // 엔티티의 데이터가 변경되면 트랜잭션이 끝날 때 알아서 jpa가 처음에 데이터를 가져올 때 백업을 해놨던 스냅샷을
    // 지금엔티티의 상태와 비교해서 알아서 업데이트를 해줌
    fun update (
        title: String,
        description: String,
        startYear: Int,
        startMonth: Int,
        endYear: Int?,
        endMonth: Int?,
        isActive: Boolean
    ) {
        this.title = title
        this.description = description
        this.startYear = startYear
        this.startMonth = startMonth
        this.endYear = endYear
        this.endMonth = endMonth
        this.isActive = isActive
    }

    fun addDetails(details: MutableList<ExperienceDetail>?) {
        if(details != null) {
            this.details.addAll(details)
        }
    }
}