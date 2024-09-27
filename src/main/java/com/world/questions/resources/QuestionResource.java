package com.world.questions.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.world.questions.dto.QuestionDTO;
import com.world.questions.entities.Question;
import com.world.questions.services.QuestionService;


@RestController
@RequestMapping(value = "/questions")
@CrossOrigin(origins = "*")
public class QuestionResource {
    
    @Autowired
    private QuestionService service;

    @GetMapping
    public ResponseEntity<List<Question>> findAllQuestions() {
        List<Question> response = service.findAllQuestion();

        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/{idParam}")
    public ResponseEntity<Question> findById(@PathVariable String idParam) {
        int id = Integer.parseInt(idParam);
        Question response = service.findById(id);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionDTO obj) {
        service.createQuestion(obj);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping(value = "/registerMany")
    public ResponseEntity<Question> createManyQuestion(@RequestBody List<QuestionDTO> list) {
        service.createManyQuestions(list);

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PostMapping(value = "/check/{id}/{option}")
    public ResponseEntity<Integer> checkResponse(@PathVariable Integer id, @PathVariable int option) {
        int response = service.checkResponse(id, option);

        return ResponseEntity.ok().body(response);
    }
    
}
