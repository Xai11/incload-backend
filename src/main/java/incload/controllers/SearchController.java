package incload.controllers;

import incload.request.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @GetMapping("/question/{question}")
    public List<String> getRequest(@PathVariable String question){
        return new SearchService(question).getUrlFoundSites();
    }
}
