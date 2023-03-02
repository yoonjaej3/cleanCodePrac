import java.util.Random;
import java.util.Scanner;

public class BaseBall {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String numberByComputer = generateNumberByComputer();

        System.out.println( "컴퓨터 숫자 : " + numberByComputer);

        gameStart(numberByComputer);

    }

    private static void gameStart(String numberByComputer) {

        boolean gameStart =false;

        while(!gameStart){

            InputView inputView= new InputView();

            inputView.message();

            String numberByHuman =  scanner.nextLine();

            gameStart = checkEqual(numberByComputer, numberByHuman);

        }
    }

    private static boolean checkEqual(String numberByComputer, String numberByHuman) {
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

    private static int countBall(String numberByComputer, String numberByHuman) {

        int result = 0;

        for(int i = 0; i< numberByComputer.length(); i++){
            for(int j = 0; j< numberByHuman.length(); j++){
                if(numberByComputer.charAt(i)== numberByHuman.charAt(j)){

                    if(i!=j)
                        result++;

                }
            }
        }
        return result;
    }

    private static int countStrike(String numberByComputer, String numberByHuman) {

        int result = 0;

        for(int i = 0; i< numberByComputer.length(); i++){
            for(int j = 0; j< numberByHuman.length(); j++){
                if(numberByComputer.charAt(i)== numberByHuman.charAt(j)){

                    if(i==j)
                        result++;

                }
            }
        }
        return result;
    }

    private static Boolean checkMode(){

        ResultView resultView = new ResultView();

        resultView.message();

        String mode = scanner.nextLine();

        if (mode.equals("1")) return resultView.resumeMessage(); //1이면 재시작  false

        if (mode.equals("2")) return resultView.exitMessage(); //2이면 종료 true

        return false;
    }

    private static String generateNumberByComputer() {
        Random random = new Random();

        String numberByComputer = Integer.toString((int)(Math.random() * 9 + 1) * 100+ (int)(Math.random() * 9 + 1) * 10 + (int)(Math.random() * 9 + 1));
        return numberByComputer;
    }
}
