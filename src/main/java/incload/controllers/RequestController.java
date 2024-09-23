package incload.controllers;

import incload.request.SearhRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

public class RequestController {

    @GetMapping("request")
    public ArrayList<String> getRequest(@PathVariable String question){
        return new SearhRequest(question).getUrlFoundSites();
    }
}
