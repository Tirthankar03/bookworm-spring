package com.aun1x.bookworm.security;


import com.aun1x.bookworm.domain.entities.UserEntity;
import com.aun1x.bookworm.repositories.UserRepository;
import lombok.extern.java.Log;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
            .orElseThrow(() -> {
                log.warning("Could not find author with name " + username);
                return new UsernameNotFoundException("Could not find author with name " + username);
            });

        return new UserPrincipal(userEntity);
    }
}
