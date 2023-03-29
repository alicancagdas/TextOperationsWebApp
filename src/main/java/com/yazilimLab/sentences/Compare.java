package com.yazilimLab.sentences;

import com.beust.ah.A;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Compare extends Seperate {

    ArrayList<String> list1 = new ArrayList<>();
    String last="";

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }


    public String birlestir(ArrayList<String> list) {

        list1 = (ArrayList<String>) list.clone();

        for (String liste: list)         System.out.println("*"+liste);


        for (int i=0; i<list.size(); i++){


            for (int j = i+1; j < list.size(); j++) {

                if ((list.get(j).startsWith(list.get(i)) || Prefix(list.get(j),list.get(i)) )|| list.get(j).equals(list.get(i))){
                    if (list.get(j).length()==list.get(i).length()){
                        if (list.get(i).compareTo(list.get(j)) > 0){
                            list.set(j," ");
                        }
                        else {
                            list.set(i," ");
                        }
                    }
                    else{
                        list.set(i," ");
                    }

                }
            }
        }


        list.removeIf(n -> (n.charAt(0) == ' '));

        for(String str:list){
            last+=str+" ";
        }

        if (list.size() == list1.size()){
            System.out.println(list.size()+"  "+list1.size());

            return "bir degisiklik yapilmadi yalnizca sona eklendi"+"****"+last+"****";

        }

        return last;
    }



    public static boolean Prefix(String str1,String s2) {

        String result = str1;
        for (int i = 1; i < 2; i++) {
            while (!s2.startsWith(result)) {
                result = result.substring(0, result.length() - 1);
            }
        }
        if (result.length()<3){
            return false;
        }

        return true;
    }



}

