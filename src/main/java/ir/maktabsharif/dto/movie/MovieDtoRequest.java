package ir.maktabsharif.dto.movie;

import ir.maktabsharif.dto.Base.BaseDtoRequest;
import lombok.*;

@Getter
@Setter
@Builder

@ToString
public class MovieDtoRequest extends BaseDtoRequest<Long> {

    private String title;
    private String genre;
    private Integer duration;
}
