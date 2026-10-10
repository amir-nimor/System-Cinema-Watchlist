package ir.maktabsharif.dto.user;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class UserDtoResponse {

    private Integer id;

    private String username;

    private String email;

}
