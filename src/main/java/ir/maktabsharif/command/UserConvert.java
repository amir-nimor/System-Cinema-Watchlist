package ir.maktabsharif.command;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.dto.user.UserDtoRequest;
import ir.maktabsharif.dto.user.UserDtoResponse;

public class UserConvert {


    private UserConvert(){}


    public static UserDao UserDtoRequestConvertToUserDao(UserDtoRequest userDtoRequest){
        return UserDao.builder()
                .username(userDtoRequest.getUsername())
                .email(userDtoRequest.getEmail())
                .password(userDtoRequest.getPassword())
                .build();
    }

    public static UserDtoResponse UserDaoConvertToUserDtoResponse(UserDao userDao){
        return UserDtoResponse.builder()
                .id(userDao.getId())
                .email(userDao.getEmail())
                .username(userDao.getUsername())
                .build();
    }
}
