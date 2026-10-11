package ir.maktabsharif.service.movie;

import ir.maktabsharif.command.MovieConvert;
import ir.maktabsharif.dao.MovieDao;
import ir.maktabsharif.dto.movie.MovieDtoRequest;
import ir.maktabsharif.dto.movie.MovieDtoResponse;
import ir.maktabsharif.exception.BuisinesException;
import ir.maktabsharif.repository.movie.MovieRepository;
import ir.maktabsharif.service.Base.BaseServiceImpl;
import jakarta.xml.bind.ValidationException;

public class MovieServiceImpl extends BaseServiceImpl<MovieDao, MovieDtoRequest, MovieDtoResponse, MovieRepository,Long> implements MovieService {

    private MovieConvert movieConvert;
    public MovieServiceImpl(MovieRepository repository) {
        super(repository);
        this.movieConvert = new MovieConvert();
    }

    @Override
    protected void validation(MovieDtoRequest movieDtoRequest) throws ValidationException {
        if (movieDtoRequest.getTitle().isBlank())throw new BuisinesException("your title is empty");
        if (movieDtoRequest.getGenre().isBlank())throw new BuisinesException("your genre is empty");
    }

    @Override
    protected MovieDao dtoRequestConvertToDao(MovieDtoRequest movieDtoRequest) {
        return movieConvert.dtoRequestConvertToDao(movieDtoRequest);
    }

    @Override
    protected MovieDtoResponse daoConvertToDtoResponse(MovieDao movieDao) {
        return movieConvert.daoCovertToDtoResponse(movieDao);
    }
}
