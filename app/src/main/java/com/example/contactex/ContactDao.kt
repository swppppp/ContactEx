package com.example.contactex

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAll() : LiveData<List<Contact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)
}

// sql 작성을 위한 DAO 인터페이스 생성
// Query, Insert, Update, Delete 등의 어노테이션 제공
// Insert와 Update에서는 onConflict속성 지정 가능저
// 중복 데이터에 대한 처리 지정 가능(REPLACE, IGNORE, ABORT, FAIL, ROLLBACK..)

// getAll -> 라이브데이터 반환!!