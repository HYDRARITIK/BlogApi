package com.hydra.demo.config;

import com.hydra.demo.IRepository.IUserRepo;
import com.hydra.demo.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepo iUserRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // diifculty in fetching user bu email
        boolean isExist=iUserRepo.existsByEmail(email);
        System.out.println(isExist);
        User user = iUserRepo.findByEmail(email).get();
        System.out.println(user);
//        UserDetails user = User.withUsername(user.getEmail()).password(user.getPassword()).authorities("USER").build();
        UserDetails userDetails=User.builder().email(user.getEmail()).password(user.getPassword()).build();
        return userDetails;
    }
}