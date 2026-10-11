package ir.maktabsharif.service.Base;





import ir.maktabsharif.dao.BaseModel.BaseModel;
import ir.maktabsharif.dto.Base.BaseDtoRequest;
import ir.maktabsharif.dto.Base.BaseDtoResponse;

import java.util.List;

public interface BaseService <T extends BaseDtoRequest<ID>, R extends BaseDtoResponse<ID>,ID extends Number>{

    R save(T t);

    ID delete(T t);

    R update(T t);

    R findById(T t);

    List<R> findAll();
}
