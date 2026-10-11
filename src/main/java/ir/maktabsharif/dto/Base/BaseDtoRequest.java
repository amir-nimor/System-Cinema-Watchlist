package ir.maktabsharif.dto.Base;

import lombok.*;

@Getter
@Setter

public class BaseDtoRequest<ID extends Number> {

    private ID id;
}
