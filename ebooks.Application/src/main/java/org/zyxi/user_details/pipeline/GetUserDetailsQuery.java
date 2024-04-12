package org.zyxi.user_details.pipeline;

import org.springframework.security.core.userdetails.UserDetails;
import org.zyxi.common.Query;


public record GetUserDetailsQuery(
        String username
) implements Query<UserDetails> {
}
