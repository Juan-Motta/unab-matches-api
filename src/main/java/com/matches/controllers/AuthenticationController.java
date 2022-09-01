package com.matches.controllers;

import com.matches.configurations.JwtUtils;
import com.matches.entities.JwtRequest;
import com.matches.entities.JwtResponse;
import com.matches.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/api/login")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            auth(jwtRequest.getUsername(),jwtRequest.getPassword());
        } catch(UsernameNotFoundException usernameNotFoundException) {
            throw new Exception("User not found");
        }
        UserDetails userDetails =  this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void auth(String username,String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException exception){
            throw  new Exception("User not active " + exception.getMessage());
        }catch (BadCredentialsException e){
            throw  new Exception("Invalid Credentials " + e.getMessage());
        }
    }
}
