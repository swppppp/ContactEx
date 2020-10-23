package com.example.contactex

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao

    companion object {
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    ContactDatabase::class.java, "contact")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}

// 실제 데이터베이스 인스턴스를 생성할 Database 클래스
// RoomDatabase를 상속하는 추상 클래스로 생성

// @Database로 entity 정의, SQLite 버전 지정
// 데이터베이스 인스턴스를 싱글톤으로 사용하기 위해 companion object에 만듦

// getInstance는 스레드 접근을 막기 위해 동기로
// 여기서 인스턴스생성, fallbackToDestructiveMigration을 통해
// 디비 갱신될 때 기존 테이블 버리고 새로 사용하도록 설정

// 이래만든 디비 인스턴스는 레포에서 호출, 시용!

