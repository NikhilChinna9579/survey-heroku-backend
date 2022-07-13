package com.serole.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serole.demo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{

	@Query(value="select count(*) from demo_User where userName=:userName and password=:password",nativeQuery = true)
	public int getUser(@Param("userName") String userName,
			@Param("password") String password);
}
