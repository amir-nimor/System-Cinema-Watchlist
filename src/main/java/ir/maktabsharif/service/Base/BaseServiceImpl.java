package ir.maktabsharif.service.Base;


import ir.maktabsharif.dao.BaseModel.BaseModel;
import ir.maktabsharif.dto.Base.BaseDtoRequest;
import ir.maktabsharif.dto.Base.BaseDtoResponse;
import ir.maktabsharif.exception.BuisinesException;
import ir.maktabsharif.exception.EntityNotFound;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.repository.BaseRepository.BaseRepository;
import jakarta.xml.bind.ValidationException;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseServiceImpl<
        A extends BaseModel<ID>,
       T extends BaseDtoRequest<ID>,
        S extends BaseDtoResponse<ID>,
        R extends BaseRepository<A,ID>,
        ID extends Number
        >
        implements BaseService<T,S,ID> {

    private R repository;


    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    protected abstract void validation(T t) throws ValidationException;


    protected abstract A dtoRequestConvertToDao(T t);
    protected abstract S daoConvertToDtoResponse(A a);

    @Override
    public S save(T t) {
        try {
            validation(t);
            A a = dtoRequestConvertToDao(t);
            A a1 = repository.create(a);
            S s = daoConvertToDtoResponse(a1);
            s.setId(a1.getId());
            return s;
        } catch (ValidationException e) {
            throw new BuisinesException("your save operation is failed => " + e.getMessage());
        }
    }

    @Override
    public ID delete(T t) {
        try {
            A a = dtoRequestConvertToDao(t);
            return repository.delete(a.getId());
        } catch (EntityNotFound | RepositoryException e) {
            throw new BuisinesException(" delete operation is failed => " + e.getMessage());
        }
    }

    @Override
    public S update(T t) {
        try {
            validation(t);
            A a = dtoRequestConvertToDao(t);
            A a1 = repository.update(a);
            return daoConvertToDtoResponse(a1);
        } catch (ValidationException | RepositoryException e) {
            throw new BuisinesException(" update operation is failed => " + e.getMessage());
        }
    }

    @Override
    public S findById(T t) {
        try {
            A a = dtoRequestConvertToDao(t);
            A a1 = repository.read(a.getId());
            return daoConvertToDtoResponse(a1);
        } catch (EntityNotFound | RepositoryException e) {
            throw new BuisinesException(" find by id operation is failed => " + e.getMessage());
        }
    }

    @Override
    public List<S> findAll() {
        try {
            List<A> aList = repository.findAll();
            List<S> sList = new ArrayList<>();
            for (A a:aList){
                sList.add(daoConvertToDtoResponse(a));
            }
            return sList;
        } catch (RuntimeException e) {
            throw new BuisinesException(" find All operation is failed => " + e.getMessage());
        }
    }
}
