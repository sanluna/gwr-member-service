package com.sanluna.members.controller;

import com.sanluna.commons.controller.BaseController;
import com.sanluna.members.model.MemberDTO;
import com.sanluna.members.model.entity.Member;
import com.sanluna.members.service.MemberService;
import com.sanluna.multitenancy.multitenancy.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "members", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class MemberController implements BaseController<MemberDTO> {

    @Autowired
    private MemberService memberService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("")
    public MemberDTO save(@RequestBody MemberDTO dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        if (TenantContext.getCurrentTenant() != null)
            dto.setTenant(TenantContext.getCurrentTenant());
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

    @Override
    @PutMapping
    public MemberDTO update(@RequestBody MemberDTO dto) {
        return memberService.update(dto.convertToEntity()).convertToDTO();
    }

    @GetMapping("search/{username}")
    public MemberDTO getByUsername(@PathVariable("username") String username) {
        System.out.println("lookup member with username: " + username);
        return memberService.findByUsername(username).convertToDTO();
    }

    @GetMapping("login/{username}")
    public MemberDTO login(@PathVariable("username") String username) {
        System.out.println("lookup member with username: " + username);
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
