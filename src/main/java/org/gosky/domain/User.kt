package org.gosky.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Created by guozhong on 17/3/14.
 */
@Entity
data class User(
        @Id
        @GeneratedValue
        var id: Long? = null,

        @Column(nullable = false)
        var name: String? = null,

        @Column(nullable = false)
        var age: Int? = null
)