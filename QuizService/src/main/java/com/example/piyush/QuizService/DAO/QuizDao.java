package com.example.piyush.QuizService.DAO;

//import com.example.piyush.QuizAppMicroservices.Model.Quiz;
import com.example.piyush.QuizService.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
