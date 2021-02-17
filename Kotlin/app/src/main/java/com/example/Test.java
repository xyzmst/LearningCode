package com.example;

import com.example.app.entity.User;
import com.example.core.utils.CacheUtils;
import com.example.core.utils.Utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Test implements TDInterface{
    public static void main(String[] args) {
        AOuter aOuter = new AOuter();
    }

    @Override
    public void testA() {
        User user = new User();
        user.getUsername();
    }

    @Override
    public void testB() {

    }
}
