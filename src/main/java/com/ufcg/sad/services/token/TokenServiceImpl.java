package com.ufcg.sad.services.token;

import com.ufcg.sad.exceptions.EntidadeNotFoundException;
import com.ufcg.sad.exceptions.utils.ParametroInvalidoException;
import com.ufcg.sad.models.token.Token;
import com.ufcg.sad.repositories.token.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by sampaio on 21/11/17.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    TokenRepository tokenRepository;

    @Override
    public Token verificaSeTokenExiste(String tokenID) throws Exception {
        Token tokenEncontrado = tokenRepository.findById(tokenID);
        if (tokenEncontrado == null){
            throw new EntidadeNotFoundException("Este Token não existe");
        }
        return tokenEncontrado;
    }

    @Override
    public List<Token> deletaTodosOsTokenAtivos() {
        List<Token> list = tokenRepository.findAll();
        tokenRepository.deleteAll();
        return list;
    }

    @Override
    public Token criaToken(Token token) {
        if(token != null){
            return tokenRepository.save(token);
        }
        throw new ParametroInvalidoException();
    }
}
