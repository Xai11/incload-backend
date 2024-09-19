package incload.service;

import incload.model.Event;
import incload.model.News;
import lombok.Data;
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

        News news1 = new News("Образование","эта штука точно поможет твоим мозгам, мажь её на свой пенис " +
                                "2-3 раза в день и ты увидишь результат...","http://dlflsflfs", new Date(2024-1900,9,21 ),"sdasd");

        newsList.addAll(Arrays.asList(news1));
    }
    public News getNews(){
            return newsList.get(0);
        }
    }
