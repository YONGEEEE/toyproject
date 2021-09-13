package com.rhfy.toyproject.dao;

import lombok.*;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name="member_info")
public class MemberDao {
    private String id;
    private String password;
    private String name;
    private String address;
    private String phone;

    @Builder
    public MemberDao(String id, String password, String name){
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
