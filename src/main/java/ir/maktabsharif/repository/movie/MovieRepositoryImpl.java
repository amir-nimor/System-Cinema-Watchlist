package ir.maktabsharif.repository.movie;

import ir.maktabsharif.dao.MovieDao;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class MovieRepositoryImpl extends BaseRepositoryImpl<MovieDao,Long> implements MovieRepository {
    public MovieRepositoryImpl() {
        super(MovieDao.class);
    }
}
