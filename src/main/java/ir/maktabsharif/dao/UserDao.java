package ir.maktabsharif.dao;


import ir.maktabsharif.dao.BaseModel.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

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

}
