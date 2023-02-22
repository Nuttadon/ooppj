package org.example;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Lab16 {
    public static void main(String[] args) throws LexicalError, SyntaxError, EvalError, IOException {
//        ExprTokenizer t = new ExprTokenizer("m = 5^2 if(10-12)then if(m)then n = nearby up else {} else {n=65}");
        ExprTokenizer t = new ExprTokenizer("m = 5^2 while(m){m=m-5}");
        ExprParser p = new ExprParser(t);
        p.Plan();
    }
}