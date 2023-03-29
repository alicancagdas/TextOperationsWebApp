package com.yazilimLab.sentences;

import com.yazilimLab.manager.Creater;

import java.util.ArrayList;
import java.util.Collections;

public class Seperate extends Creater {
    int uzunluk;
    public ArrayList<String> seperate(ArrayList<String> list){
        ArrayList<String> words = new ArrayList<String>();

        int size = list.size();
        for (int i=0; i< list.size();i++){
            list.set(i, list.get(i).toLowerCase()).trim();
        }
        String[] ilkCumle = list.get(0).split(" ");
        int uzunluk = ilkCumle.length;
        this.uzunluk = uzunluk;

        System.out.println("ilk cumle"+uzunluk);

        for (int i = 0; i<size; i++){
            String[] elements = list.get(i).split(" ");
            for (String s: elements){
                s.trim();
                words.add(s);
            }
        }

        return words;
    }
    public int firstSentencel(){
        return uzunluk;
    }
}
