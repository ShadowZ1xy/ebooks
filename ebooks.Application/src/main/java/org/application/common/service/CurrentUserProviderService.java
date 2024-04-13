package org.application.common.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.infra.user_details.model.BaseUser;

@Service
public class CurrentUserProviderService {

    public BaseUser get() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        return (BaseUser) authentication.getPrincipal();
    }

}
