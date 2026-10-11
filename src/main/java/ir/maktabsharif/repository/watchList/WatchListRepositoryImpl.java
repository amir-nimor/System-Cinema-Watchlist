package ir.maktabsharif.repository.watchList;

import ir.maktabsharif.dao.WatchlistDao;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class WatchListRepositoryImpl extends BaseRepositoryImpl<WatchlistDao,Long> implements WatchListRepository {

    public WatchListRepositoryImpl() {
        super(WatchlistDao.class);
    }
}
