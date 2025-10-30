package com.ssg.springex.member;

import lombok.Data;

@Data
public class MemberVO {
    private String id;
    private String pwd;
    private String gender;
    private String[] hobby;
}
