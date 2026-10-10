package ir.maktabsharif.dto.user;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class UserDtoRequest {

    private String username;

    private String email;

    private String password;
}
