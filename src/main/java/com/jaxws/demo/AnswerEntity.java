package com.jaxws.demo;

import lombok.Data;
import java.io.Serializable;

/*
    Объект для вычислений на стороне сервера.
    Serializable - обязательно для web-технологии SOAP.
    ДЛЯ КАЖДОГО ПОЛЯ НУЖНЫ СЕТТЕРЫ И ГЕТТЕРЫ, А ТАКЖЕ ОБЪЗАТЕЛЕН ПУСТОЙ КОНСТРУКТОР!
**/
@Data
public class AnswerEntity implements Serializable {
    private double x1;
    private double x2;

    public AnswerEntity(double a, double b) {
        x1 = a;
        x2 = b;
    }
}
