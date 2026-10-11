package ir.maktabsharif.command;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserDtoRequest;
import ir.maktabsharif.dto.user.UserDtoResponse;

public class UserConvert implements Convertable<UserDao,UserDtoRequest,UserDtoResponse> {

    @Override
    public UserDao dtoRequestConvertToDao(UserDtoRequest userDtoRequest) {
        return UserDao.builder()
                .username(userDtoRequest.getUsername())
                .email(userDtoRequest.getEmail())
                .password(userDtoRequest.getPassword())
                .build();
    }

    @Override
    public UserDtoResponse daoCovertToDtoResponse(UserDao userDao) {
        UserDtoResponse userDtoResponse = UserDtoResponse.builder()
                .email(userDao.getEmail())
                .username(userDao.getUsername())
                .build();
        userDtoResponse.setId(userDtoResponse.getId());
        return userDtoResponse;

    }
}
