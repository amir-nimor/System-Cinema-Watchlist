package ir.maktabsharif.command;

import ir.maktabsharif.dao.MovieDao;
import ir.maktabsharif.dto.movie.MovieDtoRequest;
import ir.maktabsharif.dto.movie.MovieDtoResponse;

public class MovieConvert implements Convertable<MovieDao,MovieDtoRequest,MovieDtoResponse> {


    @Override
    public MovieDao dtoRequestConvertToDao(MovieDtoRequest movieDtoRequest) {
        return MovieDao.builder()
                .title(movieDtoRequest.getTitle())
                .genre(movieDtoRequest.getGenre())
                .duration(movieDtoRequest.getDuration())
                .build();
    }

    @Override
    public MovieDtoResponse daoCovertToDtoResponse(MovieDao movieDao) {
        MovieDtoResponse movieDtoResponse = MovieDtoResponse.builder()
                .title(movieDao.getTitle())
                .genre(movieDao.getGenre())
                .duration(movieDao.getDuration())
                .build();
        movieDtoResponse.setId(movieDtoResponse.getId());
        return movieDtoResponse;

    }


}
