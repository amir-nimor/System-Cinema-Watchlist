package ir.maktabsharif.servlet;

import ir.maktabsharif.repository.movie.MovieRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepositoryImpl;
import ir.maktabsharif.repository.watchList.WatchListRepositoryImpl;
import ir.maktabsharif.service.WatchList.WatchListServiceImpl;
import ir.maktabsharif.service.movie.MovieServiceImpl;
import ir.maktabsharif.service.user.UserServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class Start implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        MovieRepositoryImpl movieRepository = new MovieRepositoryImpl();
        WatchListRepositoryImpl watchListRepository = new WatchListRepositoryImpl();

        UserServiceImpl userService = new UserServiceImpl(userRepository);

        MovieServiceImpl movieService = new MovieServiceImpl(movieRepository);

        WatchListServiceImpl watchListService = new WatchListServiceImpl(watchListRepository);



        sce.getServletContext().setAttribute("userService",userService);
        sce.getServletContext().setAttribute("movieService",movieService);
        sce.getServletContext().setAttribute("watchListService",watchListService);
    }
}
