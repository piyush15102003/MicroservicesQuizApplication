package com.example.piyush.questionService.DAO;

import com.example.piyush.questionService.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);


    @Query(value = "SELECT q.id FROM question q Where q.category=:categoryName ORDER BY RANDOM() LIMIT :numQues", nativeQuery = true)

    List<Integer> findRandomQuestionsByCategory(String category, int nums);






}
