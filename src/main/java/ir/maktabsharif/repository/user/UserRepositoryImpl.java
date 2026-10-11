package ir.maktabsharif.repository.user;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;
import ir.maktabsharif.util.HibernateUtil;

public class UserRepositoryImpl extends BaseRepositoryImpl<UserDao,Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(UserDao.class);
    }

    @Override
    public UserDao findByUsername(String username) {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("SELECT u FROM UserDao u where u.username = ?1",UserDao.class)
                        .setParameter(1,username)
                        .getSingleResult();
            });
        } catch (RuntimeException e) {
            throw new RepositoryException("your operation is failed"+e);
        }
    }
}
