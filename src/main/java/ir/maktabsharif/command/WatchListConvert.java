package ir.maktabsharif.command;

import ir.maktabsharif.dao.WatchlistDao;
import ir.maktabsharif.dto.watchLst.WatchlistDtoRequest;
import ir.maktabsharif.dto.watchLst.WatchlistDtoResponse;

public class WatchListConvert implements Convertable<WatchlistDao,WatchlistDtoRequest,WatchlistDtoResponse> {

    @Override
    public WatchlistDao dtoRequestConvertToDao(WatchlistDtoRequest watchlistDtoRequest) {
        return WatchlistDao.builder()
                .movieDao(watchlistDtoRequest.getMovieDao())
                .addAt(watchlistDtoRequest.getAddAt())
                .build();
    }

    @Override
    public WatchlistDtoResponse daoCovertToDtoResponse(WatchlistDao watchlistDao) {
        WatchlistDtoResponse watchlistDtoResponse = WatchlistDtoResponse.builder()
                .movieDao(watchlistDao.getMovieDao())
                .addAt(watchlistDao.getAddAt())
                .build();
        watchlistDtoResponse.setId(watchlistDtoResponse.getId());
        return watchlistDtoResponse;

    }
}
