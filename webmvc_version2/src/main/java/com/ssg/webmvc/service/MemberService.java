package com.ssg.webmvc.service;

import com.ssg.webmvc.dao.MemberDAO;
import com.ssg.webmvc.domain.MemberVO;
import com.ssg.webmvc.dto.MemberDTO;
import com.ssg.webmvc.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper mapper;

    MemberService() {
        this.dao = new MemberDAO();
        mapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, mpw);
        MemberDTO dto = mapper.map(vo, MemberDTO.class);
        return dto;
    }


}
