package ir.maktabsharif.dto.watchLst;

import ir.maktabsharif.dao.MovieDao;
import ir.maktabsharif.dto.Base.BaseDtoResponse;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class WatchlistDtoResponse extends BaseDtoResponse<Long> {



    private MovieDao movieDao;

    private LocalDateTime addAt;
}
