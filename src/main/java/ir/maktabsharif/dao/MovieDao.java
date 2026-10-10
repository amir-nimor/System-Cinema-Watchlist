package ir.maktabsharif.dao;

import ir.maktabsharif.dao.BaseModel.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MovieDao extends BaseModel<Long> {

    private String title;
    private String genre;
    private Integer duration;


}
