import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Random;
import java.util.Scanner;

public class BaseBall {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String numberByComputer = generateNumberByComputer();

        System.out.println( "컴퓨터 숫자 : " + numberByComputer);

        gameStart(numberByComputer);

    }

    public static void gameStart(String numberByComputer) {

        boolean gameStart =false;

        while(!gameStart){

            InputView inputView= new InputView();

            inputView.message();

            String numberByHuman =  scanner.nextLine();

            gameStart = checkEqual(numberByComputer, numberByHuman);

        }
    }

    public static boolean checkEqual(String numberByComputer, String numberByHuman) {
        if(numberByHuman.equals(numberByComputer)){

            if(checkMode()) return true;

        }
        else{

            ResultView resultView = new ResultView();

            resultView.BallMessage(countBall(numberByComputer, numberByHuman));

            resultView.StrikeMessage(countStrike(numberByComputer, numberByHuman));


        }

        return false;
    }

    public static int countBall(String numberByComputer, String numberByHuman) {

        int ballCount = 0;

        for(int i = 0; i< numberByComputer.length(); i++){
            char computerDigit = numberByComputer.charAt(i);
            for(int j = 0; j< numberByHuman.length(); j++){
                char humanDigit = numberByHuman.charAt(i);

                if(isBall(computerDigit,humanDigit,i,j)) ballCount++;

            }
        }
        return ballCount;
    }

    public static Boolean isBall(char computerDigit,char humanDigit,int computerDigitIndex , int humanDigitIndex){

        return  computerDigit == humanDigit && computerDigitIndex != humanDigitIndex;
    }

    public static int countStrike(String numberByComputer, String numberByHuman) {

        int strikeCount = 0;

        for(int i = 0; i< numberByComputer.length(); i++){
            char computerDigit = numberByComputer.charAt(i);
            for(int j = 0; j< numberByHuman.length(); j++){
                char humanDigit = numberByHuman.charAt(i);

                if(isStrike(computerDigit,humanDigit,i,j)) strikeCount++;

            }
        }
        return strikeCount;
    }

    public static Boolean isStrike(char computerDigit,char humanDigit,int computerDigitIndex , int humanDigitIndex){

        return  computerDigit == humanDigit && computerDigitIndex == humanDigitIndex;
    }

    private static Boolean checkMode(){

        ResultView resultView = new ResultView();

        resultView.message();

        String mode = scanner.nextLine();

        if (mode.equals("1")) return resultView.resumeMessage(); //1이면 재시작  false

        if (mode.equals("2")) return resultView.exitMessage(); //2이면 종료 true

        return false;
    }

    public static String generateNumberByComputer() {
        Random random = new Random();

        String numberByComputer = Integer.toString((int)(Math.random() * 9 + 1) * 100+ (int)(Math.random() * 9 + 1) * 10 + (int)(Math.random() * 9 + 1));
        return numberByComputer;
    }
}
