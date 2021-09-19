package com.rhfy.toyproject.service;

import com.rhfy.toyproject.dao.MemberDao;
import com.rhfy.toyproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberDao> findAll() {
        List<MemberDao> members = new ArrayList<>(memberRepository.findAll());
        return members;
    }

    public Optional<MemberDao> findByName(String name) {
        Optional<MemberDao> member = memberRepository.findByName(name);
        return member;
    }

    public Optional<MemberDao> findById(String id) {
        Optional<MemberDao> member = memberRepository.findById(id);
        return member;
    }

    public void deleteById(String id) {
        memberRepository.deleteById(id);
    }

    public MemberDao save(MemberDao member) {
        memberRepository.save(member);
        return member;
    }

    public Optional<MemberDao> updateById(String id, MemberDao member) {
        Optional<MemberDao> beforeMember = memberRepository.findById(id);

        if(beforeMember.isPresent()) {
            beforeMember.get().setPassword(member.getPassword());
            beforeMember.get().setAddress(member.getAddress());
            beforeMember.get().setPhone(member.getPhone());
            memberRepository.save(member);
        }
        return beforeMember;
    }
}
