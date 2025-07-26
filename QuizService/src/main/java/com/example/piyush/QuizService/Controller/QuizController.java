package com.example.piyush.QuizService.Controller;

//import com.example.piyush.QuizAppMicroservices.Model.QuestionWrapper;
//import com.example.piyush.QuizAppMicroservices.Model.Response;
//import com.example.piyush.QuizAppMicroservices.service.QuizService;
import com.example.piyush.QuizService.Model.QuestionWrapper;
import com.example.piyush.QuizService.Model.QuizDTO;
import com.example.piyush.QuizService.Model.Response;
import com.example.piyush.QuizService.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam QuizDTO quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQuestions(), quizDto.getTitle());

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(@PathVariable Integer id){
        return quizService.getQuestionsById(id);

    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz (@PathVariable Integer id , @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);

    }

}
