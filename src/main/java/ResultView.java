public class ResultView {

    public void message(){

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    }

    public void BallMessage(int ball){

        System.out.print(ball + "볼 ");

    }

    public void StrikeMessage(int strike){

        System.out.println(strike + "스트라이크 ");

    }

    public Boolean resumeMessage() {

        return false;

    }

    public Boolean exitMessage() {

        System.out.println("종료되었습니다.");

        return true;

    }
}
