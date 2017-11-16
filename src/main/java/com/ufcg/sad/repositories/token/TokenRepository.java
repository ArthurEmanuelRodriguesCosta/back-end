package com.ufcg.sad.repositories.token;

import com.ufcg.sad.models.disciplina.Disciplina;
import com.ufcg.sad.models.questionario.Questionario;
import com.ufcg.sad.models.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

/**
 * Repositório para a Entidade Token
 * Created by Arthur Sampaio on 16/11/17.
 */
public interface TokenRepository extends JpaRepository<Token, Long> {

    Token findById(String id);


}
