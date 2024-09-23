package com.fpmislata;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProgramacionFuncionalTest {

    static ProgramacionFuncional ej;

    @BeforeAll
    static void setup(){
        ej = new ProgramacionFuncional();
    }

    @Test
    void ejercicio01(){
        assertEquals(6,ej.ej01(List.of(1,2,3)));
    }

    @Test
    void ejercicio02(){
        assertEquals(List.of(2,4),ej.ej02(List.of(1,2,3,4)));
    }

    @Test
    void ejercicio03(){
        assertEquals(List.of("HOLA"),ej.ej03(List.of("hola")));
   }

    @Test
    void ejercicio04(){
        assertEquals(4,ej.ej04(List.of(1,2,3,4)));
    }

    @Test
    void ejercicio05(){
        assertEquals(2,ej.ej05(List.of(1,2,3,4),2));
    }

    @Test
    void ejercicio06(){
        assertEquals("abc",ej.ej06(List.of("a","b","c")));
    }

    @Test
    void ejercicio07(){
        assertEquals(List.of(1,4,9),ej.ej07(List.of(1,2,3)));
    }

    @Test
    void ejercicio08(){
        assertEquals(List.of(1,2,3),ej.ej08(List.of(1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,3,3,3,3)));
    }

    @Test
    void ejercicio09(){
        assertEquals(2,ej.ej09(List.of(1,2,3,4),1));
    }

    @Test
    void ejercicio10(){
        assertEquals(2,ej.ej10(List.of("a","b","abc","c"),"a"));
    }
}