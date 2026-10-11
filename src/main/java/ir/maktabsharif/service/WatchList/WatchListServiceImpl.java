package ir.maktabsharif.service.WatchList;

import ir.maktabsharif.command.WatchListConvert;
import ir.maktabsharif.dao.WatchlistDao;
import ir.maktabsharif.dto.watchLst.WatchlistDtoRequest;
import ir.maktabsharif.dto.watchLst.WatchlistDtoResponse;
import ir.maktabsharif.repository.watchList.WatchListRepository;
import ir.maktabsharif.service.Base.BaseServiceImpl;
import jakarta.xml.bind.ValidationException;

public class WatchListServiceImpl extends BaseServiceImpl<WatchlistDao, WatchlistDtoRequest, WatchlistDtoResponse, WatchListRepository,Long> implements WatchListService {

    private WatchListConvert convert;

    public WatchListServiceImpl(WatchListRepository repository) {
        super(repository);
        this.convert = new WatchListConvert();
    }

    @Override
    protected void validation(WatchlistDtoRequest watchlistDtoRequest) throws ValidationException {

    }

    @Override
    protected WatchlistDao dtoRequestConvertToDao(WatchlistDtoRequest watchlistDtoRequest) {
        return convert.dtoRequestConvertToDao(watchlistDtoRequest);
    }

    @Override
    protected WatchlistDtoResponse daoConvertToDtoResponse(WatchlistDao watchlistDao) {
        return convert.daoCovertToDtoResponse(watchlistDao);
    }
}
