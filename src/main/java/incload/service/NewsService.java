package incload.service;

import incload.model.Event;
import incload.model.News;
import incload.repository.UserRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Data
public class NewsService {

    private List<News> newsList;




    public NewsService(){
        newsList = new ArrayList<>();
//
//        Доделать

    }
    public List<News> getNews(){
            return newsList;
        }

    }
