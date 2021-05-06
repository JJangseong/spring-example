package com.example.springexample.web.controller

import com.example.springexample.domain.Member
import com.example.springexample.web.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired

open class BaseTest {

    @Autowired lateinit var memberRepository: MemberRepository

    open fun getMember(): Member {
        return Member(1L, 12F, "sungjin")
    }

    open fun saveMemberByRepository() {
        memberRepository.save(getMember())
    }
}