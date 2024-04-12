package org.zyxi.user_details.pipeline;

import org.zyxi.common.Query;
import org.zyxi.user_details.model.CurrentUser;


public record GetUserDetailsQuery(
        String username
) implements Query<CurrentUser> {
}
