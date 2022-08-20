package kz.com.factoring.Service;

import kz.com.factoring.Entity.News;
import kz.com.factoring.Repository.NewsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(newsRepository.findAll());
    }
    public ResponseEntity<?> getById(long id) {
        return ResponseEntity.ok(newsRepository.findById(id));
    }
    public void delete(long id){
        newsRepository.deleteById(id);
    }
    public News update(@RequestBody News person){
        return  newsRepository.save(person);
    }

}