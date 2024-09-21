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
//        News news1 = new News("Образование","эта штука точно поможет твоим мозгам, мажь её на свой пенис " +
//                                "2-3 раза в день и ты увидишь результат...","http://dlflsflfs", "sdasd");
//
//        newsList.addAll(Arrays.asList(news1));

    }
    public List<News> getNews(){
            return newsList;
        }

    }
