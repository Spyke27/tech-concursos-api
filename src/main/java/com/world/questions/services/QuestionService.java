package com.world.questions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.questions.dto.QuestionDTO;
import com.world.questions.entities.Question;
import com.world.questions.repositories.QuestionRepository;

@Service
public class QuestionService {
    
    @Autowired
    private QuestionRepository repository;


    public void createQuestion(QuestionDTO obj) {
        Question question = new Question();

        question.setQuestion(obj.question());
        question.setAnswer(obj.answer());
        question.setRight(0);
        question.setWrong(0);
        question.setOptionA(obj.optionA());
        question.setOptionB(obj.optionB());
        question.setOptionC(obj.optionC());
        question.setOptionD(obj.optionD());
        question.setOptionE(obj.optionE());

        repository.save(question);
    } 
    
    public void createManyQuestions(List<QuestionDTO> list) {
        for(QuestionDTO item : list) {
            createQuestion(item);
        }
    }

    public List<Question> findAllQuestion() {
        List<Question> questions = repository.findAll();

        if(questions.size() < 1){
            System.out.println("Error: Connot find questions!");
        }

        return questions;
    }

    public Question findById(int id) {
        Optional<Question> question = repository.findById(id);

        return question.get();
    }

    public int checkResponse(int id, int option) {
        Optional<Question> question = repository.findById(id);

        if(question.get().getAnswer() == option){
            question.get().setRight(question.get().getRight() + 1);
            repository.save(question.get());
            return 1;
        } else {
            question.get().setWrong(question.get().getWrong() + 1);
            repository.save(question.get());
            return 2;
        }
    }
}
