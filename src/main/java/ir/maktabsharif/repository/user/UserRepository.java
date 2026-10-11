package ir.maktabsharif.repository.user;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.repository.BaseRepository.BaseRepository;

public interface UserRepository extends BaseRepository<UserDao,Integer> {
    UserDao findByUsername(String username);
}
