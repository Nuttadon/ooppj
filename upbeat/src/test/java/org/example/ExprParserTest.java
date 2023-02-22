//package org.example;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.NoSuchElementException;
//
//class ExprParserTest {
//    @Test
//    public void TestParse() throws LexicalError, SyntaxError, EvalError {
//        Map<String,Integer> variables = new HashMap<>();
//        ExprTokenizer t = new ExprTokenizer("1+2*3");
//        ExprParser p = new ExprParser(t,variables);
//        assertEquals(7,p.parse());
//        assertEquals("(1+(2*3))",p.prettyPrinter());
//
//        ExprTokenizer t2 = new ExprTokenizer("1+2/5");
//        ExprParser p2 = new ExprParser(t2,variables);
//        assertEquals(1.4,p2.parse());
//        assertEquals("(1+(2/5))",p2.prettyPrinter());
//
//        ExprTokenizer t3 = new ExprTokenizer("1 + 2");
//        ExprParser p3 = new ExprParser(t3,variables);
//        assertEquals(3,p3.parse());
//        assertEquals("(1+2)",p3.prettyPrinter());
//
//        ExprTokenizer t4 = new ExprTokenizer("3 - 1");
//        ExprParser p4 = new ExprParser(t4,variables);
//        assertEquals(2,p4.parse());
//        assertEquals("(3-1)",p4.prettyPrinter());
//
//        ExprTokenizer t5 = new ExprTokenizer("10/1");
//        ExprParser p5 = new ExprParser(t5,variables);
//        assertEquals(10,p5.parse());
//        assertEquals("(10/1)",p5.prettyPrinter());
//
//        ExprTokenizer t6 = new ExprTokenizer("2 * 3 + 4 - 5 / 7 % 6");
//        ExprParser p6 = new ExprParser(t6,variables);
//        assertEquals(9.285714285714286,p6.parse());
//        assertEquals("(((2*3)+4)-((5/7)%6))",p6.prettyPrinter());
//
//        ExprTokenizer t7 = new ExprTokenizer("1++++2");
//        ExprParser p7 = new ExprParser(t7,variables);
//        assertThrows(SyntaxError.class,()->p7.parse());
//
//        ExprTokenizer t8 = new ExprTokenizer("(((2*3)-4)*5)");
//        ExprParser p8 = new ExprParser(t8,variables);
//        assertEquals(10,p8.parse());
//        assertEquals("(((2*3)-4)*5)",p8.prettyPrinter());
//
//        ExprTokenizer t9 = new ExprTokenizer("(2*((3-4)*5))");
//        ExprParser p9 = new ExprParser(t9,variables);
//        assertEquals(-10,p9.parse());
//        assertEquals("(2*((3-4)*5))",p9.prettyPrinter());
//
//        ExprTokenizer t10 = new ExprTokenizer("(2*(3-(4*5)))");
//        ExprParser p10 = new ExprParser(t10,variables);
//        assertEquals(-34,p10.parse());
//        assertEquals("(2*(3-(4*5)))",p10.prettyPrinter());
//
//        ExprTokenizer t11 = new ExprTokenizer("((2*3)-(4*5))");
//        ExprParser p11 = new ExprParser(t11,variables);
//        assertEquals(-14,p11.parse());
//        assertEquals("((2*3)-(4*5))",p11.prettyPrinter());
//
//        ExprTokenizer t12 = new ExprTokenizer("(4*5+3)");
//        ExprParser p12 = new ExprParser(t12,variables);
//        assertEquals(23,p12.parse());
//        assertEquals("((4*5)+3)",p12.prettyPrinter());
//
//        ExprTokenizer t13 = new ExprTokenizer("+ - *");
//        ExprParser p13 = new ExprParser(t13,variables);
//        assertThrows(SyntaxError.class,()->p13.parse());
//
//        ExprTokenizer t14 = new ExprTokenizer("1 + 2");
//        ExprParser p14 = new ExprParser(t14,variables);
//        assertEquals(3,p14.parse());;
//        assertEquals("(1+2)",p14.prettyPrinter());
//
//        ExprTokenizer t15 = new ExprTokenizer("0/1/1/1/1/1");
//        ExprParser p15 = new ExprParser(t15,variables);
//        assertEquals(0,p15.parse());
//        assertEquals("(((((0/1)/1)/1)/1)/1)",p15.prettyPrinter());
//
//        ExprTokenizer t16 = new ExprTokenizer("10/ 2 /4/0");
//        ExprParser p16 = new ExprParser(t16,variables);
//        assertThrows(ArithmeticException.class,()->p16.parse());
//        assertEquals("(((10/2)/4)/0)",p16.prettyPrinter());
//
//        ExprTokenizer t17 = new ExprTokenizer("100%13%5%8%0");
//        ExprParser p17 = new ExprParser(t17,variables);
//        assertThrows(ArithmeticException.class,()->p17.parse());
//        assertEquals("((((100%13)%5)%8)%0)",p17.prettyPrinter());
//
//        ExprTokenizer t18 = new ExprTokenizer("10/ 2 /4/1 /7");
//        ExprParser p18 = new ExprParser(t18,variables);
//        assertEquals(0.17857142857142858,p18.parse());
//        assertEquals("((((10/2)/4)/1)/7)",p18.prettyPrinter());
//
//        ExprTokenizer t19 = new ExprTokenizer("50 20 +");
//        ExprParser p19 = new ExprParser(t19,variables);
//        assertThrows(SyntaxError.class,()->p19.parse());
//
//
//        ExprTokenizer t20 = new ExprTokenizer("1250 + 250 -250* 2/ 10%2");
//        ExprParser p20 = new ExprParser(t20,variables);
//        assertEquals(1500,p20.parse());
//        assertEquals("((1250+250)-(((250*2)/10)%2))",p20.prettyPrinter());
//
//        ExprTokenizer t21 = new ExprTokenizer("1+2+3+4+5+6+7+8+9+10");
//        ExprParser p21 = new ExprParser(t21,variables);
//        assertEquals(55,p21.parse());
//        assertEquals("(((((((((1+2)+3)+4)+5)+6)+7)+8)+9)+10)",p21.prettyPrinter());
//
//        ExprTokenizer t22 = new ExprTokenizer("1-2-3-4-5-6-7-8-9-10");
//        ExprParser p22 = new ExprParser(t22,variables);
//        assertEquals(-53,p22.parse());
//        assertEquals("(((((((((1-2)-3)-4)-5)-6)-7)-8)-9)-10)",p22.prettyPrinter());
//
//        ExprTokenizer t23 = new ExprTokenizer("1 - 2 - 3 - 4 - 5 - 6 - 7 - 8 - 9 -10");
//        ExprParser p23 = new ExprParser(t23,variables);
//        assertEquals(-53,p23.parse());
//        assertEquals("(((((((((1-2)-3)-4)-5)-6)-7)-8)-9)-10)",p23.prettyPrinter());
//
//        ExprTokenizer t24 = new ExprTokenizer("1*2*3*4*5*6*7*8*9*10");
//        ExprParser p24 = new ExprParser(t24,variables);
//        assertEquals(3628800,p24.parse());
//        assertEquals("(((((((((1*2)*3)*4)*5)*6)*7)*8)*9)*10)",p24.prettyPrinter());
//
//        ExprTokenizer t25 = new ExprTokenizer("1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10");
//        ExprParser p25 = new ExprParser(t25,variables);
//        assertEquals(3628800,p25.parse());
//        assertEquals("(((((((((1*2)*3)*4)*5)*6)*7)*8)*9)*10)",p25.prettyPrinter());
//
//        ExprTokenizer t26 = new ExprTokenizer("100%13%5%8%8");
//        ExprParser p26 = new ExprParser(t26,variables);
//        assertEquals(4,p26.parse());
//        assertEquals("((((100%13)%5)%8)%8)",p26.prettyPrinter());
//
//        ExprTokenizer t27 = new ExprTokenizer("10 80 60 ");
//        ExprParser p27 = new ExprParser(t27,variables);
//        assertThrows(SyntaxError.class,()->p27.parse());
//
//
//        ExprTokenizer t28 = new ExprTokenizer("1025 -333 25 * 9");
//        ExprParser p28 = new ExprParser(t28,variables);
//        assertThrows(SyntaxError.class,()->p28.parse());
//
//
//
//        ExprTokenizer t29 = new ExprTokenizer("1000 %0");
//        ExprParser p29 = new ExprParser(t29,variables);
//        assertThrows(ArithmeticException.class,()->p29.parse());
//        assertEquals("(1000%0)",p29.prettyPrinter());
//
//        ExprTokenizer t30 = new ExprTokenizer("10 +5 +88 + - 9");
//        ExprParser p30 = new ExprParser(t30,variables);
//        assertThrows(SyntaxError.class,()->p30.parse());
//
//        ExprTokenizer t31 = new ExprTokenizer("1000 + 600 / 2");
//        ExprParser p31 = new ExprParser(t31,variables);
//        assertEquals(1300,p31.parse());
//        assertEquals("(1000+(600/2))",p31.prettyPrinter());
//
//        ExprTokenizer t32 = new ExprTokenizer("23 + 45*6");
//        ExprParser p32 = new ExprParser(t32,variables);
//        assertEquals(293,p32.parse());
//        assertEquals("(23+(45*6))",p32.prettyPrinter());
//
//        ExprTokenizer t33 = new ExprTokenizer("7-3/30*2");
//        ExprParser p33 = new ExprParser(t33,variables);
//        assertEquals(6.8,p33.parse());
//        assertEquals("(7-((3/30)*2))",p33.prettyPrinter());
//
//        ExprTokenizer t34 = new ExprTokenizer("-10/0");
//        ExprParser p34 = new ExprParser(t34,variables);
//        assertThrows(SyntaxError.class,()->p34.parse());
//
//
//        ExprTokenizer t35 = new ExprTokenizer("7/0");
//        ExprParser p35 = new ExprParser(t35,variables);
//        assertThrows(ArithmeticException.class,()->p35.parse());
//        assertEquals("(7/0)",p35.prettyPrinter());
//
//        ExprTokenizer t36 = new ExprTokenizer("1+2*");
//        ExprParser p36 = new ExprParser(t36,variables);
//        assertThrows(NoSuchElementException.class,()->p36.parse());
//        assertEquals("2",p36.prettyPrinter());
//
//        ExprTokenizer t37 = new ExprTokenizer("");
//        ExprParser p37 = new ExprParser(t37,variables);
//        assertThrows(NoSuchElementException.class,()->p37.parse());
//        assertEquals("",p37.prettyPrinter());
//
//        ExprTokenizer t38 = new ExprTokenizer("1**1");
//        ExprParser p38 = new ExprParser(t38,variables);
//        assertThrows(SyntaxError.class,()->p38.parse());
//    //For SyntaxErrors we don't care what the prettyPrinter will return due to the Syntax that can not be parse
//
//        variables.put("n",3);
//        variables.put("o",4);
//        variables.put("X",5);
//        variables.put("y",2);
//        variables.put("z", 2);
//        variables.put("V", 0);
//        variables.put("k", -3);
//
//        ExprTokenizer t39 = new ExprTokenizer("1+X+y");
//        ExprParser p39 = new ExprParser(t39,variables);
//        assertEquals(8,p39.parse());
//        assertEquals("((1+X)+y)",p39.prettyPrinter());
//
//        ExprTokenizer t40 = new ExprTokenizer("1+x");
//        ExprParser p40 = new ExprParser(t40,variables);
//        assertThrows(EvalError.class,()->p40.parse());
//
//        ExprTokenizer t41 = new ExprTokenizer("1+X+y-z");
//        ExprParser p41 = new ExprParser(t41,variables);
//        assertEquals(6,p41.parse());
//        assertEquals("(((1+X)+y)-z)",p41.prettyPrinter());
//
//        ExprTokenizer t42 = new ExprTokenizer("X+y+z+n+o");
//        ExprParser p42 = new ExprParser(t42,variables);
//        assertEquals(16,p42.parse());
//        assertEquals("((((X+y)+z)+n)+o)",p42.prettyPrinter());
//
//        ExprTokenizer t43 = new ExprTokenizer("X-y+z+n+o");
//        ExprParser p43 = new ExprParser(t43,variables);
//        assertEquals(12,p43.parse());
//        assertEquals("((((X-y)+z)+n)+o)",p43.prettyPrinter());
//
//        ExprTokenizer t44 = new ExprTokenizer("X*y+z+n+o");
//        ExprParser p44 = new ExprParser(t44,variables);
//        assertEquals(19,p44.parse());
//        assertEquals("((((X*y)+z)+n)+o)",p44.prettyPrinter());
//
//        ExprTokenizer t45 = new ExprTokenizer("X+y/z+n+o");
//        ExprParser p45 = new ExprParser(t45,variables);
//        assertEquals(13,p45.parse());
//        assertEquals("(((X+(y/z))+n)+o)",p45.prettyPrinter());
//
//        ExprTokenizer t46 = new ExprTokenizer("X+y+z%n+o");
//        ExprParser p46 = new ExprParser(t46,variables);
//        assertEquals(13,p46.parse());
//        assertEquals("(((X+y)+(z%n))+o)",p46.prettyPrinter());
//
//        ExprTokenizer t47 = new ExprTokenizer("X+y+z+n%V");
//        ExprParser p47 = new ExprParser(t47,variables);
//        assertThrows(ArithmeticException.class,()->p47.parse());
//        assertEquals("(n%V)",p47.prettyPrinter()); // do n%v first then go to other operation
//
//        ExprTokenizer t48 = new ExprTokenizer("1%V");
//        ExprParser p48 = new ExprParser(t48,variables);
//        assertThrows(ArithmeticException.class,()->p48.parse());
//        assertEquals("(1%V)",p48.prettyPrinter());
//
//        ExprTokenizer t49 = new ExprTokenizer("b+c ");
//        ExprParser p49 = new ExprParser(t49,variables);
//        assertThrows(EvalError.class,()->p49.parse());
//        assertEquals("(b+c)",p49.prettyPrinter()); // no element but can print
//
//        ExprTokenizer t50 = new ExprTokenizer("3+k ");
//        ExprParser p50 = new ExprParser(t50,variables);
//        assertEquals(0,p50.parse());
//        assertEquals("(3+k)",p50.prettyPrinter());
//
//        ExprTokenizer t51 = new ExprTokenizer("3-k ");
//        ExprParser p51 = new ExprParser(t51,variables);
//        assertEquals(6,p51.parse());
//        assertEquals("(3-k)",p51.prettyPrinter());
//
//        ExprTokenizer t52 = new ExprTokenizer("3*k ");
//        ExprParser p52 = new ExprParser(t52,variables);
//        assertEquals(-9,p52.parse());
//        assertEquals("(3*k)",p52.prettyPrinter());
//
//        ExprTokenizer t53 = new ExprTokenizer("3/k ");
//        ExprParser p53 = new ExprParser(t53,variables);
//        assertEquals(-1,p53.parse());
//        assertEquals("(3/k)",p53.prettyPrinter());
//
//        ExprTokenizer t54 = new ExprTokenizer("3%k ");
//        ExprParser p54 = new ExprParser(t54,variables);
//        assertEquals(0,p54.parse());
//        assertEquals("(3%k)",p54.prettyPrinter());
//
//        ExprTokenizer t55 = new ExprTokenizer("k-k ");
//        ExprParser p55 = new ExprParser(t55,variables);
//        assertEquals(0,p55.parse());
//        assertEquals("(k-k)",p55.prettyPrinter());
//
//        ExprTokenizer t56 = new ExprTokenizer("V%V");
//        ExprParser p56= new ExprParser(t56,variables);
//        assertThrows(ArithmeticException.class,()->p56.parse());
//
//    }
//}