package ir.maktabsharif.dto.user;


import ir.maktabsharif.dto.Base.BaseDtoRequest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class UserDtoRequest extends BaseDtoRequest<Integer> {

    private String username;

    private String email;

    private String password;
}
