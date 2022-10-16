package com.company.M2ChallengeDiazNicholas.controller;

import com.company.M2ChallengeDiazNicholas.models.MathSolution;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;


@RestController
public class MathSolutionController {


    @RequestMapping("/greeting")
    public String greeting(@Valid MathSolution mathSolution) {
        return "Hello there!";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution addTwoNumbers(@RequestBody @Valid @NotNull MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new IllegalArgumentException( "Please enter a valid number.");
        }
        mathSolution.setOperation("add");
        mathSolution.setAnswer(mathSolution.getOperand1() + mathSolution.getOperand2());
            Integer answer = mathSolution.getOperand1() + mathSolution.getOperand2();
            mathSolution.setAnswer(answer);
        return mathSolution;
    }
    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtractTwoNumbers(@RequestBody @Valid @NotNull MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new IllegalArgumentException( "Please enter a valid number. ");
        }
        mathSolution.setOperation("minus");
        mathSolution.setAnswer(mathSolution.getOperand1() - mathSolution.getOperand2());
        Integer answer = mathSolution.getOperand1() - mathSolution.getOperand2();
        mathSolution.setAnswer(answer);
        return mathSolution;
    }
    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiplyTwoNumbers(@RequestBody @Valid @NotNull MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new IllegalArgumentException( "Please enter a valid number. ");
        }
        mathSolution.setOperation("multiply");
        mathSolution.setAnswer(mathSolution.getOperand1() * mathSolution.getOperand2());
        Integer answer = mathSolution.getOperand1() * mathSolution.getOperand2();
        mathSolution.setAnswer(answer);
        return mathSolution;
    }
    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution divideTwoNumbers(@RequestBody @Valid @NotNull MathSolution mathSolution) {
        if (mathSolution.getOperand1() == null || mathSolution.getOperand2() == null) {
            throw new IllegalArgumentException( "Please enter a valid number. ");
        }
        mathSolution.setOperation("divide");
        mathSolution.setAnswer(mathSolution.getOperand1() / mathSolution.getOperand2());
        Integer answer = mathSolution.getOperand1() / mathSolution.getOperand2();
        mathSolution.setAnswer(answer);
        return mathSolution;
    }


    }



