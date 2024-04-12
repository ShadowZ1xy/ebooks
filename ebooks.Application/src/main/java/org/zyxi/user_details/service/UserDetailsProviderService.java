package org.zyxi.user_details.service;

import an.awesome.pipelinr.Pipeline;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zyxi.user_details.pipeline.GetUserDetailsQuery;

@Service
@RequiredArgsConstructor
public class UserDetailsProviderService implements UserDetailsService {

    private final Pipeline pipeline;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return pipeline.send(new GetUserDetailsQuery(username));
    }
}
