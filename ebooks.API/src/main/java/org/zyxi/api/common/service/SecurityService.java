package org.zyxi.api.common.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.zyxi.infra.user_details.model.BaseUser;

import java.util.UUID;

@Service
public class SecurityService {

    public boolean IsSelf(UUID userId) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        BaseUser baseUser = (BaseUser) authentication.getPrincipal();
        return baseUser.getUserId().resourceId().equals(userId);
    }

}
