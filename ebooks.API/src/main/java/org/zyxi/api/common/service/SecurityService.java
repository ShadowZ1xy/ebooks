package org.zyxi.api.common.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.zyxi.user_details.model.CurrentUser;

import java.util.UUID;

@Service
public class SecurityService {

    public boolean IsSelf(UUID userId) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        CurrentUser currentUser = (CurrentUser) authentication.getPrincipal();
        return currentUser.getUserId().resourceId().equals(userId);
    }

}
