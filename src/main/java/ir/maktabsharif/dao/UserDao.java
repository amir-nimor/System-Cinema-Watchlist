package ir.maktabsharif.dao;


import ir.maktabsharif.dao.BaseModel.BaseModel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.sql.results.graph.Fetch;

import java.util.List;

@Entity
@Table(name = "Users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDao extends BaseModel<Integer> {


    private String username;

    private String email;

    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<WatchlistDao> watchlistDaoList;

}
