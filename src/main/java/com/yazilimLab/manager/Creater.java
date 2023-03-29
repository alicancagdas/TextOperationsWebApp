package com.yazilimLab.manager;

import com.yazilimLab.sentences.Sentences;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Objects;

public class Creater {
    ArrayList<String> list = new ArrayList<>();

    public ArrayList<String> create(@ModelAttribute Sentences sentences)
    {
        list.add(sentences.getSentence1());
        list.add(sentences.getSentence2());
        list.add(sentences.getSentence3());
        list.add(sentences.getSentence4());
        list.add(sentences.getSentence5());
        list.add(sentences.getSentence6());
        list.add(sentences.getSentence7());
        list.add(sentences.getSentence8());
        list.add(sentences.getSentence9());
        list.add(sentences.getSentence10());
        list.add(sentences.getSentence11());
        list.add(sentences.getSentence12());
        list.add(sentences.getSentence13());
        list.add(sentences.getSentence14());
        list.add(sentences.getSentence15());


        list.removeIf(Objects::isNull);



        return list;
    }

}
