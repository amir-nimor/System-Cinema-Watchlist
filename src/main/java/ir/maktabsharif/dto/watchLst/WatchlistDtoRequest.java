package ir.maktabsharif.dto.watchLst;

import ir.maktabsharif.dao.MovieDao;
import ir.maktabsharif.dto.Base.BaseDtoRequest;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class WatchlistDtoRequest extends BaseDtoRequest<Long> {


    private MovieDao movieDao;

    private LocalDateTime addAt;
}
