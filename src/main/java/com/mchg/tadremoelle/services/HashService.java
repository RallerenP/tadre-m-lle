package com.mchg.tadremoelle.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class HashService implements IHashService{
    private final int rounds = 10;

    @Override
    public String hash(String text) {
        return BCrypt.hashpw(text, BCrypt.gensalt(rounds));
    }

    @Override
    public boolean verify(String hash, String text) {
        return BCrypt.checkpw(hash, text);
    }
}
