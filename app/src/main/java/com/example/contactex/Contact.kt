package com.example.contactex

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    var id: Long?,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "number")
    var number: String,
    @ColumnInfo(name = "initial")
    var initial: Char
) {
    constructor() : this(null, "", "", '\u0000')
}

// primary key null일 경우 자동생성
// 컬럼명과 변수명 같을경우 어노테이션 생략가능
