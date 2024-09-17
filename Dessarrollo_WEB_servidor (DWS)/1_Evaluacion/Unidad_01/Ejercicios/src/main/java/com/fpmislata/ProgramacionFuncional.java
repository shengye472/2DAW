package com.fpmislata;

import java.util.List;
import java.util.Optional;

public class ProgramacionFuncional {
        public int ej01(List<Integer> listaEnteros){
                return listaEnteros.stream()
                        .reduce(0,Integer::sum);
        }

        public List<Integer> ej02(List<Integer> list){
                return list.stream()
                        .filter(num -> num % 2 == 0).
                        toList();
        }

        public List<String> ej03(List<String> cadena){
                return cadena.stream()
                        .map(String::toUpperCase)
                        .toList();
        }

        public Optional<Integer> ej04(List<Integer> numero){
                return numero.stream()
                        .max(Integer::compareTo);
//                        .reduce(0,Integer::max);
        }

        public long ej05(List<Integer> numbers, int number2){
                return numbers
                        .stream()
                        .filter(number -> number > number2)
                        .count();
        }

        public String ej06(List<String> cadena){
                return cadena.stream()
                        .reduce("",String::concat);
        }

        public List<Integer> ej07(List<Integer> numbers){
                return numbers.stream()
                        .map(number -> number * number)
                        .toList();
        }

        public List<Integer> ej08(List<Integer> numbers){
                return numbers.stream()
                        .distinct()
                        .toList();
        }

        public Integer ej09(List<Integer> numbers, int number2) {
                return numbers
                        .stream()
                        .filter(number -> number > number2)
                        .findFirst().orElse(0);
        }

        public long ej10(List<String> stringList, String string){
                return stringList
                        .stream()
                        .filter(st -> st.startsWith(string))
                        .count();
        }
}