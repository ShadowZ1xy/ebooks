package org.application.user_details.pipeline;

import org.application.common.pipeline.Query;
import org.infra.user_details.model.BaseUser;


public record GetUserDetailsQuery(
        String username
) implements Query<BaseUser> {
}
