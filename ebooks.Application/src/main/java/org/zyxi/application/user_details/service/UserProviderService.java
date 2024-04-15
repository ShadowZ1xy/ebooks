package org.zyxi.application.user_details.service;

import an.awesome.pipelinr.Pipeline;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.zyxi.application.user_details.pipeline.GetUserDetailsQuery;
import org.zyxi.infra.user_details.model.BaseUser;

@Service
@RequiredArgsConstructor
public class UserProviderService implements UserDetailsService {

    private final Pipeline pipeline;

    @Override
    public BaseUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return pipeline.send(new GetUserDetailsQuery(username));
    }
}
