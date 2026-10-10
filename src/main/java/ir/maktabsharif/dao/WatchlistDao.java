package ir.maktabsharif.dao;

import ir.maktabsharif.dao.BaseModel.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class WatchlistDao extends BaseModel<Long> {


    @ManyToOne
    private MovieDao movieDao;

    private LocalDateTime addAt;


    public WatchlistDao(MovieDao movieDao){
        this.movieDao = movieDao;
        this.addAt = LocalDateTime.now();
    }




}
