package com.serole.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serole.demo.entity.FeedbackAnswerMap;

@Repository
public interface FeedbackAnswerMapRepository extends CrudRepository<FeedbackAnswerMap,Long>{

}
