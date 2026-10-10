package ir.maktabsharif.dao;

import ir.maktabsharif.dao.BaseModel.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class WatchlistDao extends BaseModel<Long> {


    @ManyToOne
    private MovieDao movieDao;

    private LocalDateTime addAt;


    public WatchlistDao(MovieDao movieDao){
        this.movieDao = movieDao;
        this.addAt = LocalDateTime.now();
    }




}
