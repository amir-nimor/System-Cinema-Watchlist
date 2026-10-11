package ir.maktabsharif.service.user;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserDtoRequest;
import ir.maktabsharif.dto.user.UserDtoResponse;
import ir.maktabsharif.service.Base.BaseService;

public interface UserService extends BaseService<UserDtoRequest, UserDtoResponse,Integer> {
    UserDao findByUsername(String username);
}
