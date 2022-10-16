package com.company.M2ChallengeDiazNicholas.controller;

import com.company.M2ChallengeDiazNicholas.models.MathSolution;
import com.company.M2ChallengeDiazNicholas.models.Month;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthController {

    /**
     * Use the month list here?? Yes
     *  Referenced asList for the array   https://www.geeksforgeeks.org/arrays-aslist-method-in-java-with-examples/
     *
     */
    public static List<Month> monthList = new ArrayList<>(Arrays.asList(
            new Month(1, "January"),
            new Month(2, "February"),
            new Month(3, "March"),
            new Month(4, "April"),
            new Month(5, "May"),
            new Month(6, "June"),
            new Month(7, "July"),
            new Month(8, "August"),
            new Month(9, "September"),
            new Month(10, "October"),
            new Month(11, "November"),
            new Month(12, "December"))
    );

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Month getMonthByNumber(@PathVariable Integer monthNumber) {
//        Month foundMonth;
        if (monthNumber < 1 || monthNumber > 12 ) {
            throw new IllegalArgumentException("Input out of range - Number must be between 1 and 12");
        }
            Month foundMonth = null;
            for (Month month : monthList) {
                if (month.getMonthNumber() == monthNumber) {
                    foundMonth = month;
                    break;
                }
            }

            return foundMonth;
        }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Month getRandomMonth() {
        Random rand = new Random();
        int randomMonthNumber = rand.nextInt(12) + 1;
        Month randomMonth = null;

        for (Month month : monthList) {
            if (month.getMonthNumber() == randomMonthNumber) {
                randomMonth = month;
                break;
            }
        }
        return randomMonth;
    }


}

