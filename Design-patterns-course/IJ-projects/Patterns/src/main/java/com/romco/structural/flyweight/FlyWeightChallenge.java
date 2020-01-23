package com.romco.structural.flyweight;

import java.util.*;

class Sentence
{
    private List<WordToken> tokens;
    private String text;
    
    public Sentence(String plainText)
    {
        this.text = plainText;
        tokens = new ArrayList<>();
        for (int i = 0; i < plainText.split(" ").length; i++) {
            tokens.add(new WordToken());
        }
    }
    
    public WordToken getWord(int index)
    {
        if (index > tokens.size()) {
            return null;
        }
        return tokens.get(index);
    }
    
    @Override
    public String toString()
    {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (String word : text.split(" ")) {
            if (count != 0) {
                sb.append(" ");
            }
            if (tokens.get(count).capitalize) {
                sb.append(word.toUpperCase());
            } else {
                sb.append(word.toLowerCase());
            }
            count++;
        }
        return sb.toString();
    }
    
    class WordToken
    {
        public boolean capitalize = false;
    }
}

public class FlyWeightChallenge {
    public static void main(String[] args) {
        Sentence s = new Sentence("hello world");
        s.getWord(1).capitalize = true;
        System.out.println(s);
    }
}
