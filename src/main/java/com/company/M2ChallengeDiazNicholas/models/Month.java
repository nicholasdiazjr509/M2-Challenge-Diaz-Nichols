package com.company.M2ChallengeDiazNicholas.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;


public class Month {
    @NotEmpty (message = "Please enter a valid month name")
    @NotNull(message = "Please enter a valid month name")
    String monthName;

    @NotEmpty(message = "Please enter a valid month number.")
    @NotNull(message = "Please enter a valid month number")
    int monthNumber;

    public Month() {
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public Month(int monthNumber, String monthName) {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
    }

    public Month(int monthNumber) {
        this.monthNumber = monthNumber;
    }


    public int randomMonthGenerator() {
        return (int) Math.round(1 + (Math.random() * (12 - 1)));
    }

    public String getMonthName() {
        return monthName;
    }

    public Month setMonthName(String monthName) {
      this.monthName = monthName;
      return this;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Month month = (Month) o;

        if (monthNumber != month.monthNumber) return false;
        return Objects.equals(monthName, month.monthName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthName, monthNumber);
    }

}
//    public int randomMonthGenerator() {
//        return 0;
//    }
//    public int randomMonthGenerator() {
//        return (int) Math.round(1 + (Math.random() * (12 -1 )));
//           }

