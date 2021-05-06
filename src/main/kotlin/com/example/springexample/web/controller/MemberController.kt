package com.example.springexample.web.controller

import com.example.springexample.domain.Member
import com.example.springexample.web.repository.MemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/member")
class MemberController {

    @Autowired lateinit var memberRepository: MemberRepository

    @PostMapping
    fun saveMember(@RequestBody member: Member): ResponseEntity<Member>{
        memberRepository.save(member)

        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("{memberId}")
    fun removeMember(@PathVariable("memberId") memberId: Long): ResponseEntity<Member>{
        memberRepository.deleteById(memberId)
        return ResponseEntity(HttpStatus.OK)
    }

    @PutMapping
    fun updateMember(@RequestBody member: Member): ResponseEntity<Member> {
        memberRepository.save(member)
        return ResponseEntity(HttpStatus.OK)
    }
}