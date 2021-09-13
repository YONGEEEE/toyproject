package com.rhfy.toyproject.repository;

import com.rhfy.toyproject.dao.MemberDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberDao, String> {
}
