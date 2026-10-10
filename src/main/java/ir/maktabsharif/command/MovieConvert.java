package ir.maktabsharif.command;

import ir.maktabsharif.dao.MovieDao;
import ir.maktabsharif.dto.movie.MovieDtoRequest;
import ir.maktabsharif.dto.movie.MovieDtoResponse;

public class MovieConvert {

    private MovieConvert(){}

    public static MovieDao movieDtoRequestConvertToMovieDao (MovieDtoRequest movieDtoRequest){
        return MovieDao.builder()
                .title(movieDtoRequest.getTitle())
                .genre(movieDtoRequest.getGenre())
                .duration(movieDtoRequest.getDuration())
                .build();
    }


    public static MovieDtoResponse movieDaoConvertToMovieDtoResponse(MovieDao movieDao){
        return MovieDtoResponse.builder()
                .title(movieDao.getTitle())
                .id(movieDao.getId())
                .genre(movieDao.getGenre())
                .duration(movieDao.getDuration())
                .build();
    }
}
