package com.example.springexample.web.repository

import com.example.springexample.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long>{
}