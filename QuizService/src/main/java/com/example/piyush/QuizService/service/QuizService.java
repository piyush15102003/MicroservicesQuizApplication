package com.example.piyush.QuizService.service;

//import com.example.piyush.QuizService.DAO.QuestionDao;
import com.example.piyush.QuizService.DAO.QuizDao;
import com.example.piyush.QuizService.Model.QuestionWrapper;
import com.example.piyush.QuizService.Model.Quiz;
import com.example.piyush.QuizService.Model.Response;
import com.example.piyush.QuizService.feign.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

//    @Autowired
//    QuestionDao questionDao;
    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int nums, String title) {


        List<Integer> questions = quizInterface.getQuestionsForQuiz(category,nums).getBody(); // call the  generate url from question service RestTEMPLATE
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
//
        return new ResponseEntity<>("success", HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuestionsById(Integer id) {
          Quiz quiz =quizDao.findById(id).get();
          List<Integer> questionId = quiz.getQuestions();
          ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsById(questionId);
          return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
         ResponseEntity<Integer> score = quizInterface.getScores(responses);
         return score;
    }
}
