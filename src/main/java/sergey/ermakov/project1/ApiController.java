package sergey.ermakov.project1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ApiController {
    ArrayList<String> messages=new ArrayList<>();

    @GetMapping("books1")
    public String getText() {
        return ("Hello text");
    }

    @PostMapping("books")
    public void createMessage(@RequestBody String mes){
        messages.add(mes);
    }

    @GetMapping("books")
    public List<String> getMessages(){
        return messages;
    }

    @GetMapping("books/{index}")
    public String getMessage (@PathVariable("index") Integer i){
        return messages.get((int) i);
    }

    @DeleteMapping("books/{index}")
    public void deleteMessage (@PathVariable("index") Integer i){
        messages.remove((int) i);
    }

    @PutMapping("books/{index}")
    public void putMessage (@PathVariable("index") Integer i, @RequestBody String mes){
        messages.remove((int)i);
        messages.add(i,mes);
    }

}
