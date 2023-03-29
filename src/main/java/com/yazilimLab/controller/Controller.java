package com.yazilimLab.controller;

import com.yazilimLab.db.MongoDb;
import com.yazilimLab.manager.Creater;
import com.yazilimLab.sentences.Compare;
import com.yazilimLab.sentences.SentenceManager;
import com.yazilimLab.sentences.Sentences;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@org.springframework.stereotype.Controller
public class Controller  extends Sentences{
    @RequestMapping("/")
    public String index()
    {
        return "home";
    }
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelAndView save(@ModelAttribute Sentences sentences)
    {

        long startTime = System.nanoTime();


        MongoDb mongoDb = new MongoDb();
        ArrayList<String> list = new ArrayList<String>();


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");

        Compare compare = new Compare();
        Creater creater = new Creater();

        ArrayList<String> created = creater.create(sentences);
        ArrayList<String> seperated = compare.seperate(created);


        sentences.setSonuc(compare.birlestir(seperated));
        list.add(compare.birlestir(seperated));



        /*
         *ADD DATABASE

         */

        mongoDb.add(created);
        mongoDb.add(list);

        long endTime = System.nanoTime();
        long estimatedTime = endTime - startTime;
        double seconds = (double)estimatedTime/1000000000;

        sentences.setCount(seconds);
        return modelAndView;

    }
}