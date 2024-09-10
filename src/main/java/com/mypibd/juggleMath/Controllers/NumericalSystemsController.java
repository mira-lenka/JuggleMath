package com.mypibd.juggleMath.Controllers;

import com.mypibd.juggleMath.Models.NumericalSystems;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/numsys")
public class NumericalSystemsController {

  @PostMapping("/conv")
  public String changeOfBase(@RequestBody ConversionRequest conversionRequest) {

      int base1 = conversionRequest.getBase1();
      int base2 = conversionRequest.getBase2();
      String number = conversionRequest.getString();

      return NumericalSystems.changeOfBase(base1,base2,number);

  }

  @PostMapping("/doubleconv")
  public String doubleChangeOfBase(@RequestBody ConversionRequest conversionRequest) {

      int base1 = conversionRequest.getBase1();
      int base2 = conversionRequest.getBase2();
      String number = conversionRequest.getString();

      if (base1 == 2) {
          return NumericalSystems.doubleToDec(number);
      }
      else {
          return NumericalSystems.doubleToBinary(number);
      }

  }

  @PostMapping("/op")
  public String binaryOperation(@RequestBody OperationRequest operationRequest) {

      String num1 = operationRequest.getNum1();
      String num2 = operationRequest.getNum2();
      Character symbol = operationRequest.getSymbol();

      String result = "";

      switch (symbol) {

          case '+':
              result = NumericalSystems.binaryAddition(num1,num2);
              break;
          case '-':
              result = NumericalSystems.binarySubtraction(num1,num2);
              break;
          case 'x':
              result = NumericalSystems.binaryMultiplication(num1,num2);
              break;
          case '/':
              result = NumericalSystems.binaryDivision(num1,num2);
              break;
      }
      return result;
  }

    public static class OperationRequest {

      String num1;
      String num2;

        public String getNum1() {
            return num1;
        }

        public void setNum1(String num1) {
            this.num1 = num1;
        }

        public String getNum2() {
            return num2;
        }

        public void setNum2(String num2) {
            this.num2 = num2;
        }

        public Character getSymbol() {
            return symbol;
        }

        public void setSymbol(Character symbol) {
            this.symbol = symbol;
        }

        Character symbol;

  }

    public static class ConversionRequest {

        private int base1;
        private int base2;
        private String string;

        public int getBase1() {
            return base1;
        }

        public void setBase1(int base1) {
            this.base1 = base1;
        }

        public int getBase2() {
            return base2;
        }

        public void setBase2(int base2) {
            this.base2 = base2;
        }

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }
    }

}
