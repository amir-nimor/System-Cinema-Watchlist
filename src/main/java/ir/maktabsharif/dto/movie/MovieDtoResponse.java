package ir.maktabsharif.dto.movie;

import ir.maktabsharif.dto.Base.BaseDtoResponse;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class MovieDtoResponse extends BaseDtoResponse<Long> {


    private String title;
    private String genre;
    private Integer duration;
}
