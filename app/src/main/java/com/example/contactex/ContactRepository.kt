package com.example.contactex

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import java.lang.Exception

class ContactRepository(application: Application) {

    private val contactDatabase = ContactDatabase.getInstance(application)!!
    private val contactDao: ContactDao = contactDatabase.contactDao()
    private val contacts: LiveData<List<Contact>> = contactDao.getAll()

    fun getAll(): LiveData<List<Contact>> {
        return contacts
    }

    fun insert(contact: Contact) {
        try {
            val thread = Thread {
                contactDao.insert(contact) }
            thread.start()
        } catch (e: Exception){
            Log.d("EXCEPTION", e.message.toString())
        }
    }

    fun delete(contact: Contact) {
        try {
            val thread = Thread {
                contactDao.delete(contact)
            }
            thread.start()
        } catch (e: Exception) {
            Log.d("EXCEPTION", e.message.toString())
        }
    }
}

// RoomDb를 메인스레드에서 접근하면 크래쉬 발생
// ui화면 오래 멈춰있을수 있기때문에 메인스레드에서 접근불가
// 별도의 스레드에서 접근---> 나중에 코루틴으로 해보기

