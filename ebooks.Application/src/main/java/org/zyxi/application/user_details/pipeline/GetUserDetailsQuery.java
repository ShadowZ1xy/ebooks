package org.zyxi.application.user_details.pipeline;

import org.zyxi.application.common.pipeline.Query;
import org.zyxi.infra.user_details.model.BaseUser;


public record GetUserDetailsQuery(
        String username
) implements Query<BaseUser> {
}
