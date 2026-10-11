package ir.maktabsharif.command;

public interface Convertable <T,Q,S>{

    T  dtoRequestConvertToDao(Q q);

    S daoCovertToDtoResponse(T t);




}
