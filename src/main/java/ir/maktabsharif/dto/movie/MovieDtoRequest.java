package ir.maktabsharif.dto.movie;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class MovieDtoRequest {

    private String title;
    private String genre;
    private Integer duration;
}
