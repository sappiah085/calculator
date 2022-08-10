package calculator.app;

import java.time.Instant;

public class Calculator {
    public String initialVal;
    public String sign;
    public String newVal;
    public Calculator(){
        newVal = "";
    }
    public String getResult(){
        return newVal;
    }
    public void answer(){
        if(this.newVal == "" || this.initialVal == ""){
            this.newVal = "0";
            this.initialVal = "0";
        }
        float first_value = Float.parseFloat(this.initialVal);
        float second_value = Float.parseFloat(this.newVal);

        float answers;
        if(this.sign.endsWith("+")) {
            answers = first_value + second_value;
            newVal = Float.toString(answers);
        }else if(this.sign.endsWith("-")){
            answers = first_value - second_value;
            newVal = Float.toString(answers);
        }else if(this.sign.endsWith("*")) {
            answers = first_value * second_value;
            newVal = Float.toString(answers);
        }else{
                answers = first_value / second_value;
                newVal = Float.toString(answers);
        }

    }
    public void appendNumber(String number){

        if(number.toLowerCase().endsWith("-/+") ){
           this.newVal = this.newVal.startsWith("-") ? this.newVal.substring(1, this.newVal.length()): "-"+this.newVal;
        }else if (number.toLowerCase().endsWith("+") || number.toLowerCase().endsWith("-")|| number.toLowerCase().endsWith("*")|| number.toLowerCase().endsWith("-") || number.toLowerCase().endsWith("/") ){

                sign = number;
                initialVal = newVal;
                newVal = "";

        }else if(number.toLowerCase().endsWith("=")){
          this.answer();
        }else if(number.toLowerCase().endsWith("c") ){
            this.newVal = "";
            this.initialVal = "";
        }else if(number.toLowerCase().endsWith("del")){
            this.newVal = this.newVal.substring(0, this.newVal.length() - 1);
        }else if(number.toLowerCase().endsWith("%")){
            Float answer = Float.parseFloat(this.newVal);
            answer = answer / 100;
            this.newVal = Float.toString(answer);
        }
        else {
            newVal+= number;
        }
    }
}
