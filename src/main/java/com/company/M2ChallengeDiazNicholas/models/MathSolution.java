package com.company.M2ChallengeDiazNicholas.models;

import javax.validation.constraints.NotNull;
import java.util.Objects;

// /**Referenced site: MockMVC Test for subtract two numbers.
// * https://www.anycodings.com/1questions/103756/mockmvc-test-for-subtract-two-numbers
// * https://davidlozzi.com/2021/04/29/challenge-1-a-calculator-a-restful-man-and-a-springy-boot-walk-into-a-bar/
// * https://spring.io/guides/tutorials/rest/*/

public class MathSolution {
    @NotNull(message = "Please enter a valid number for operand1.")
    public Integer operand1;
    @NotNull(message = "Please enter a valid number for operand2.")
    public Integer operand2;
    public String operation;
    public Integer answer;

    public MathSolution() {

    }
    public MathSolution(Integer operand1, Integer operand2){
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
    public MathSolution(Integer operand1, Integer operand2, String operation, Integer answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }
    public Integer getOperand1() {
        return operand1;
    }

    public void setOperand1(Integer operand1) {
        this.operand1 = operand1;
    }

    public Integer getOperand2() {
        return operand2;
    }

    public void setOperand2(Integer operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution that = (MathSolution) o;
        return Objects.equals(operand1, that.operand1) && Objects.equals(operand2, that.operand2) && Objects.equals(operation, that.operation) && Objects.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operation, answer);
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operation='" + operation + '\'' +
                ", answer=" + answer +
                '}';
    }
}