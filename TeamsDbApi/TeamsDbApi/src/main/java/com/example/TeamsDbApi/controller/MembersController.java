package com.example.TeamsDbApi.controller;

import com.example.TeamsDbApi.exeption.MemberNotFoundEx;
import com.example.TeamsDbApi.model.entity.Members;
import com.example.TeamsDbApi.model.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MembersController {

    @Autowired
    MembersRepository membersRepository;

    // Get all records
    @GetMapping("/members")
    public List getAllMembers() {
        return membersRepository.findAll();
    }

    // Create a member
    @PostMapping("/add_member")
    public Members addMember(@RequestBody Members member) {
        return membersRepository.save(member);
    }

    // Get a member by his id
    @GetMapping("/members/{id}")
    public Members getMemberById(@PathVariable(value = "id") Integer memberId) throws MemberNotFoundEx {
        return membersRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundEx(memberId));
    }

    //update member/member info
    @PutMapping("/update_member/{id}")
    public Members updateMember(@PathVariable(value = "id") Integer memberId, @RequestBody Members memberDetails) throws MemberNotFoundEx {
        Members member = membersRepository.findById(memberId).orElseThrow(() -> new MemberNotFoundEx(memberId));

        member.setMember_full_name(memberDetails.getMember_full_name());
        member.setMember_position(memberDetails.getMember_position());
        member.setMember_age(memberDetails.getMember_age());

        Members updatedMember = membersRepository.save(member);
        return updatedMember;
    }

    // Delete member by his Id
    @DeleteMapping("/delete_member/{id}")
    public ResponseEntity deleteMember(@PathVariable(value = "id") Integer memberId) throws MemberNotFoundEx {
        Members member = membersRepository.findById(memberId).orElseThrow(()-> new MemberNotFoundEx(memberId));
        membersRepository.delete(member);
        return ResponseEntity.ok().build();
    }

}
