package kz.com.factoring.Service;

import kz.com.factoring.Entity.News;
import kz.com.factoring.Entity.Request;
import kz.com.factoring.Repository.NewsRepository;
import kz.com.factoring.Repository.RequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(requestRepository.findAll());
    }
    public ResponseEntity<?> getById(long id) {
        return ResponseEntity.ok(requestRepository.findById(id));
    }
    public void delete(long id){
        requestRepository.deleteById(id);
    }
    public Request update(@RequestBody Request person){
        return  requestRepository.save(person);
    }

}