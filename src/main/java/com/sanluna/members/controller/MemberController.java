package com.sanluna.members.controller;

import com.sanluna.members.model.MemberDTO;
import com.sanluna.members.model.entity.Member;
import com.sanluna.members.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.web.bind.annotation.*;
import sanluna.gwr.security.principal.GWRPrincipal;
import sanluna.gwr.security.principal.GWRTokenConverter;
import sanluna.gwr.security.principal.GWRTokenHelper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "members", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("")
    public MemberDTO save(@RequestBody MemberDTO dto) {
        return memberService.save(dto.convertToEntity()).convertToDTO();
    }

    @GetMapping("")
    public List<MemberDTO> fetchAll() {
        return memberService.fetchAll().stream().map(Member::convertToDTO).collect(Collectors.toList());
    }

    @GetMapping("{id}")
    public MemberDTO getById(@PathVariable("id") String ID) {
        return memberService.getById(ID).convertToDTO();
    }

    @GetMapping("search/{username}")
    public MemberDTO getByUsername(@PathVariable("username") String username) {
        return memberService.findByUsername(username).convertToDTO();
    }

    @DeleteMapping("")
    public void delete(@RequestBody MemberDTO dto) {
        memberService.delete(dto.convertToEntity());
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") String ID) {
        memberService.deleteById(ID);
    }

}
