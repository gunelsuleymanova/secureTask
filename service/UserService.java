package com.example.user.service;

import com.example.user.dao.entity.UserEntity;
import com.example.user.dao.repos.UserRepos;
import com.example.user.dto.UserLoginDto;
import com.example.user.dto.UserRequestDto;
import com.example.user.mapper.UserMapper;
import com.example.user.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepos userRepos;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtService jwtService;



/// sifrelenmemis
    public void createUser(UserRequestDto d){
       var user = userRepos.save(userMapper.dtoToEntity(d));
    }



///sifrelenmis
    public void save(UserRequestDto f){
        var user= UserEntity.builder()
                .username(f.getUsername())
                .email(f.getEmail()).
                password(passwordEncoder.encode(f.getPassword()))
                .balance(f.getBalance())
                .build();
        userRepos.save(user);
    }






    public String sinin(UserLoginDto d){
        var user =userRepos.findByUsername(d.getUsername()).orElseThrow();
        if(!passwordEncoder.matches(d.getPassword(),user.getPassword()))
            throw new RuntimeException("user not found");
        return jwtService.generateToken(user);
    }




    public UserRequestDto get(Long id){
        var user = userRepos.findById(id).orElseThrow();
        var us= userMapper.entityToDto(user);
        return us;
    }













}
