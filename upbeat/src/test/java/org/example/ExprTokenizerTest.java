//package org.example;
//
//import org.junit.jupiter.api.Test;
//
//import java.io.IOError;
//import java.io.IOException;
//import java.util.NoSuchElementException;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//class ExprTokenizerTest {
//    @Test
//    public void TokenTest() throws LexicalError, SyntaxError {
//        ExprTokenizer t = new ExprTokenizer("1+ 2  *3-4  /1%  2");
//        assertEquals("1",t.peek());
//        t.consume();
//        assertEquals("+",t.peek());
//        t.consume();
//        assertEquals("2",t.peek());
//        t.consume();
//        assertEquals("*",t.peek());
//        t.consume();
//        assertEquals("3",t.peek());
//        t.consume();
//        assertEquals("-",t.peek());
//        t.consume();
//        assertEquals("4",t.peek());
//        t.consume();
//        assertEquals("/",t.peek());
//        t.consume();
//        assertEquals("1",t.peek());
//        t.consume();
//        assertEquals("%",t.peek());
//        t.consume();
//        assertEquals("2",t.peek());
//
//
//        ExprTokenizer y = new ExprTokenizer("1!");
//        assertThrows(LexicalError.class,()->y.consume());
//
//        assertThrows(LexicalError.class,()->new ExprTokenizer("^"));
//
//        ExprTokenizer y1 = new ExprTokenizer("");
//        assertThrows(NoSuchElementException.class,()->y1.peek());
//        assertThrows(NoSuchElementException.class,()->y1.consume());
//
//        ExprTokenizer y2 = new ExprTokenizer("1+");
//        y2.consume();
//        assertEquals("+",y2.peek());
//        y2.consume();
//        assertThrows(NoSuchElementException.class,()->y2.consume());
//
//        ExprTokenizer y3 = new ExprTokenizer("1/2%4");
//        y3.peek();
//        y3.consume();
//        assertEquals("/",y3.peek());
//
//        ExprTokenizer y4 = new ExprTokenizer("+");
//        assertThrows(SyntaxError.class,()->y4.consume("-"));
//        assertThrows(SyntaxError.class,()->y4.consume("*"));
//        assertThrows(SyntaxError.class,()->y4.consume("/"));
//        assertThrows(SyntaxError.class,()->y4.consume("%"));
//        assertThrows(SyntaxError.class,()->y4.consume(")"));
//        assertThrows(SyntaxError.class,()->y4.consume("("));
//        assertEquals("+",y4.consume());
//
//        ExprTokenizer y5 = new ExprTokenizer("-");
//        assertThrows(SyntaxError.class,()->y5.consume("+"));
//        assertThrows(SyntaxError.class,()->y5.consume("*"));
//        assertThrows(SyntaxError.class,()->y5.consume("/"));
//        assertThrows(SyntaxError.class,()->y5.consume("%"));
//        assertThrows(SyntaxError.class,()->y5.consume(")"));
//        assertThrows(SyntaxError.class,()->y5.consume("("));
//        assertEquals("-",y5.consume());
//
//        ExprTokenizer y6 = new ExprTokenizer("*");
//        assertThrows(SyntaxError.class,()->y6.consume("+"));
//        assertThrows(SyntaxError.class,()->y6.consume("-"));
//        assertThrows(SyntaxError.class,()->y6.consume("/"));
//        assertThrows(SyntaxError.class,()->y6.consume("%"));
//        assertThrows(SyntaxError.class,()->y6.consume(")"));
//        assertThrows(SyntaxError.class,()->y6.consume("("));
//        assertEquals("*",y6.consume());
//
//        ExprTokenizer y7 = new ExprTokenizer("/");
//        assertThrows(SyntaxError.class,()->y7.consume("+"));
//        assertThrows(SyntaxError.class,()->y7.consume("-"));
//        assertThrows(SyntaxError.class,()->y7.consume("*"));
//        assertThrows(SyntaxError.class,()->y7.consume("%"));
//        assertThrows(SyntaxError.class,()->y7.consume(")"));
//        assertThrows(SyntaxError.class,()->y7.consume("("));
//        assertEquals("/",y7.consume());
//
//        ExprTokenizer y8 = new ExprTokenizer("%");
//        assertThrows(SyntaxError.class,()->y8.consume("+"));
//        assertThrows(SyntaxError.class,()->y8.consume("-"));
//        assertThrows(SyntaxError.class,()->y8.consume("/"));
//        assertThrows(SyntaxError.class,()->y8.consume("*"));
//        assertThrows(SyntaxError.class,()->y8.consume(")"));
//        assertThrows(SyntaxError.class,()->y8.consume("("));
//        assertEquals("%",y8.consume());
//
//        ExprTokenizer y9 = new ExprTokenizer("(");
//        assertThrows(SyntaxError.class,()->y9.consume("+"));
//        assertThrows(SyntaxError.class,()->y9.consume("-"));
//        assertThrows(SyntaxError.class,()->y9.consume("/"));
//        assertThrows(SyntaxError.class,()->y9.consume("*"));
//        assertThrows(SyntaxError.class,()->y9.consume("%"));
//        assertThrows(SyntaxError.class,()->y9.consume(")"));
//        assertEquals("(",y9.consume());
//
//        ExprTokenizer y10 = new ExprTokenizer(")");
//        assertThrows(SyntaxError.class,()->y10.consume("+"));
//        assertThrows(SyntaxError.class,()->y10.consume("-"));
//        assertThrows(SyntaxError.class,()->y10.consume("/"));
//        assertThrows(SyntaxError.class,()->y10.consume("*"));
//        assertThrows(SyntaxError.class,()->y10.consume("%"));
//        assertThrows(SyntaxError.class,()->y10.consume("("));
//        assertEquals(")",y10.consume());
//
//        ExprTokenizer y11 = new ExprTokenizer("ABCdef$");
//        assertEquals("A",y11.consume());
//        assertEquals("B",y11.consume());
//        assertEquals("C",y11.consume());
//        assertEquals("d",y11.consume());
//        assertEquals("e",y11.consume());
//        assertEquals("f",y11.peek());
//        assertThrows(LexicalError.class,()->y11.consume());
//
//        ExprTokenizer y12 = new ExprTokenizer("A+B-  %Cd *ef&");
//        assertEquals("A",y12.consume());
//        assertEquals("+",y12.consume());
//        assertEquals("B",y12.consume());
//        assertEquals("-",y12.consume());
//        assertEquals("%",y12.consume());
//        assertEquals("C",y12.consume());
//        assertEquals("d",y12.consume());
//        assertEquals("*",y12.consume());
//        assertEquals("e",y12.consume());
//        assertEquals("f",y12.peek());
//        assertThrows(LexicalError.class,()->y12.consume());
//    }
//
//}