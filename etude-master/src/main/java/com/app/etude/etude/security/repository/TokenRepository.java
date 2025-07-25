package com.app.etude.etude.security.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.etude.etude.security.models.Token;



public interface TokenRepository extends JpaRepository<Token, Integer> {


	 @Query(value = """
	     select t from Token t inner join User u\s
	     on t.user.id = u.id\s
	     where u.id = :id and (t.expired = false or t.revoked = false)\s
	     """)
	 List<Token> findAllValidTokenByUser(Long id);


	 Optional<Token> findByToken(String token);
	}
