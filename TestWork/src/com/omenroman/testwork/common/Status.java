/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omenroman.testwork.common;

/**
 *
 * @author админ
 */
public enum Status {

    DB_EMPTY("Ошибка, в базе нет значений"),
    DEPOSIT_ADD("OK"),
    DEPOSIT_DELETE("Депозит удален"),
    DEPOSIT_NOT_FOUND("Депозит не найден"),
    BANK_NOT_FOUND("Банк не найден"),
    TYPE_NOT_FOUND("Тип не найден"),
    DEPOSITOR_NOT_FOUND("Вкладчик не найден"),
    ACCOUNT_NOT_FOUND("Счет не найден"),
    ACCOUNT_EXIST("Вклад с таким id уже есть"),
    INCORRECT_DIGITS("Числа не могут быть <=0");
    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
