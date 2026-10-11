package ir.maktabsharif.service.user;

import ir.maktabsharif.command.UserConvert;
import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserDtoRequest;
import ir.maktabsharif.dto.user.UserDtoResponse;
import ir.maktabsharif.exception.BuisinesException;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.service.Base.BaseServiceImpl;
import jakarta.xml.bind.ValidationException;

public class UserServiceImpl extends BaseServiceImpl<UserDao, UserDtoRequest, UserDtoResponse, UserRepository,Integer> implements UserService {

    private UserConvert userConvert;


    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.userConvert = new UserConvert();
    }

    @Override
    protected void validation(UserDtoRequest userDtoRequest) throws ValidationException {
        if (userDtoRequest.getUsername().isBlank())throw new BuisinesException("your username is empty");
        if (userDtoRequest.getPassword().isBlank())throw new BuisinesException("your password is empty");
    }

    @Override
    protected UserDao dtoRequestConvertToDao(UserDtoRequest userDtoRequest) {
        return userConvert.dtoRequestConvertToDao(userDtoRequest);
    }

    @Override
    protected UserDtoResponse daoConvertToDtoResponse(UserDao userDao) {
        return userConvert.daoCovertToDtoResponse(userDao);
    }

    @Override
    public UserDao findByUsername(String username) {
        try {
            return new UserRepositoryImpl().findByUsername(username);
        }catch (RuntimeException e){
            throw new BuisinesException("your operation if filed");
        }
    }
}
