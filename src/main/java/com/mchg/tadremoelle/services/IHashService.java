package com.mchg.tadremoelle.services;

public interface IHashService {
    String hash(String text);
    boolean verify(String hash, String text);
}
