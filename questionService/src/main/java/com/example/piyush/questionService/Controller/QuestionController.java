package com.example.piyush.questionService.Controller;

import com.example.piyush.questionService.Model.Question;
import com.example.piyush.questionService.Model.QuestionWrapper;
import com.example.piyush.questionService.Model.Response;
import com.example.piyush.questionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions/")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);

    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }

    // generate service from question service // generate
    // give them the question on basis of questionid // getQuestions(questionsid)

    @GetMapping("generate/")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName , @RequestParam Integer numQues){
        return questionService.getQuestionsForQuiz(categoryName,numQues);
    }

    @PostMapping("getQuestions")
    public ResponseEntity< List<QuestionWrapper>> getQuestionsById(@RequestBody List<Integer> questionsId){
        return questionService.getQuestionById(questionsId);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScores(@RequestBody List<Response> responses){
        return questionService.getScore(responses);
    }

}

