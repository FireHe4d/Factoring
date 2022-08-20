package kz.com.factoring.Controller;

import kz.com.factoring.Entity.News;
import kz.com.factoring.Entity.Request;
import kz.com.factoring.Service.NewsService;
import kz.com.factoring.Service.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestController {
    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @RequestMapping(value="/request",method= RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(requestService.getAll());
    }
    @RequestMapping(value="/request/{id}", method=RequestMethod.GET, headers = "Accept=application/json")
    public ResponseEntity<?> get(@PathVariable long id){
        return ResponseEntity.ok(requestService.getById(id));}
    @RequestMapping(value = "/request/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void delete(@PathVariable int id){
        requestService.delete(id);
    }
    @CrossOrigin
    @RequestMapping(value="/request",method=RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<?> update(@RequestBody Request request){
        return ResponseEntity.ok(requestService.update(request));
    }
}