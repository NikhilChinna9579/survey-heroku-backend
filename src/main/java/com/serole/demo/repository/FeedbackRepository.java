package com.serole.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serole.demo.entity.Feedback;

import java.util.List;


@Repository
public interface FeedbackRepository extends CrudRepository<Feedback,Long>{
    @Query(value="select * from Feedback order by feedbackId desc",nativeQuery = true)
    public List<Feedback> getAllFeedback();

}
