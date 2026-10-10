package ir.maktabsharif.command;

import ir.maktabsharif.dao.WatchlistDao;
import ir.maktabsharif.dto.watchLst.WatchlistDtoRequest;
import ir.maktabsharif.dto.watchLst.WatchlistDtoResponse;

public class WatchListConvert {

    private WatchListConvert(){}


    public static WatchlistDao watchlistDtoConvertToWatchListDao(WatchlistDtoRequest watchlistDtoRequest){
        return WatchlistDao.builder()
                .movieDao(watchlistDtoRequest.getMovieDao())
                .addAt(watchlistDtoRequest.getAddAt())
                .build();
    }


    public static WatchlistDtoResponse watchListDaoConvertToWatchListDtoResponse(WatchlistDao watchlistDao){
        return WatchlistDtoResponse.builder()
                .movieDao(watchlistDao.getMovieDao())
                .addAt(watchlistDao.getAddAt())
                .id(watchlistDao.getId())
                .build();
    }
}
