package com.xyzmst.generics;

import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.ArrayList;
import java.util.List;

public class Test {



    public void test(){

        ArrayList<? super AppCompatTextView> list = new ArrayList<TextView>();

    }

    <T extends Runnable, Serializable> void someMethod(T param) {

    }

    public  <T> void merge(T item, List<T> list){
        list.add(item);
    }
}
