package com.serole.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serole.demo.entity.Question;


@Repository
public interface QuestionRepository extends CrudRepository<Question,Long>{

}
