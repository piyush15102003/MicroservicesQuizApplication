package com.example.piyush.QuizService.feign;

import com.example.piyush.QuizService.Model.QuestionWrapper;
import com.example.piyush.QuizService.Model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONSERVICE")
public interface QuizInterface {

    @GetMapping("questions/generate/")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(
            @RequestParam String categoryName , @RequestParam Integer numQues);

    @PostMapping("questions/getQuestions")
    public ResponseEntity< List<QuestionWrapper>> getQuestionsById(
            @RequestBody List<Integer> questionsId);

    @PostMapping("questions/getScore")
    public ResponseEntity<Integer> getScores(
            @RequestBody List<Response> responses);
}
