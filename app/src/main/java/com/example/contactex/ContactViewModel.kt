package com.example.contactex

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactViewModel (application: Application) : AndroidViewModel(application) {

    private val repository = ContactRepository(application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<Contact>> {
        return contacts
    }

    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact )
    }
}

// Application을 파라미터로 사용
// repo를 통해 Room데이터베이스의 인스턴스를 만들때 context필요
// 액티비티 context 사용하게 되면 액티비티가 destroy된 경우 메모리 릭 발생 가능

// db제어 함수는 레포함수 이용해서 설정
