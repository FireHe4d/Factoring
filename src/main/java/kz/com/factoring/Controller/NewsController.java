package kz.com.factoring.Controller;

import kz.com.factoring.Entity.News;
import kz.com.factoring.Service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }
@CrossOrigin
    @RequestMapping(value="/news",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(newsService.getAll());
    }
    @RequestMapping(value="/news/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id){
        return ResponseEntity.ok(newsService.getById(id));}
    @RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable int id){
        newsService.delete(id);
    }
    @RequestMapping(value="/news",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody News news){
        return ResponseEntity.ok(newsService.update(news));
    }
}
