package com.ssg.webmvc.domain;

import lombok.*;
import org.springframework.test.context.TestConstructor;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
    private String mid;
    private String mpw;
    private String mname;
}
