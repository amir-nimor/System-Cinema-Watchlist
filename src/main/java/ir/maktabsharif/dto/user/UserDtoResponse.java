package ir.maktabsharif.dto.user;


import ir.maktabsharif.dto.Base.BaseDtoResponse;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class UserDtoResponse  extends BaseDtoResponse<Integer> {


    private String username;

    private String email;

}
