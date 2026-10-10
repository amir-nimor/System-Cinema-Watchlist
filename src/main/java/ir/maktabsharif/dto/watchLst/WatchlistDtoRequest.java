package ir.maktabsharif.dto.watchLst;

import ir.maktabsharif.dao.MovieDao;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class WatchlistDtoRequest {


    private MovieDao movieDao;

    private LocalDateTime addAt;
}
