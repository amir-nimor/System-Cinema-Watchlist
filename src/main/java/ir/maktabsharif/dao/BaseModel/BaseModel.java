package ir.maktabsharif.dao.BaseModel;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Setter
@Getter
public class BaseModel <ID extends Number>{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private ID id;



}
