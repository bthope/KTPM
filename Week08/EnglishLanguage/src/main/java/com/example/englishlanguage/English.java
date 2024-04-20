package com.example.englishlanguage;
import com.example.language.Language;
import lombok.Getter;


@Getter
public class English implements Language {

    private final String PATH = "D:\\HKVIII\\KTPM\\KTPM\\lab08\\EnglishLanguage\\src\\main\\resources\\dictionary.txt";

    @Override
    public String sayHello(String name) {
        return "Huu Bang "+name;
    }

    @Override
    public String name() {
        return "English";
    }
}
