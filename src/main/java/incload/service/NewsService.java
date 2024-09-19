package incload.service;

import incload.model.News;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Data
public class NewsService {

    //public List<News> getNews;
    private List<News> newsList;

    public NewsService(){
        newsList = new ArrayList<>();

        News news1 = new News("Образование","эта штука точно поможет твоим мозгам, мажь её на свой пенис 2-3 раза в день и ты увидишь результат...","17.09.2024");

        newsList.addAll(Arrays.asList(news1));
    }
    public News getNews(){
            return newsList.get(0);
        }
    }
