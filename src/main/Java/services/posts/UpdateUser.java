package services.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Builder
@Accessors(chain = true)
@Getter
public class UpdateUser {

    private int id;
    private String username;


}
