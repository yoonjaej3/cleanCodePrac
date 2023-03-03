import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallTest {



    @Test
    @DisplayName("볼 여부 테스트")
    void test(){

        //given
        String numberByComputer ="369";
        String numberByHuman="123";

        int computerDigitIndex =0;
        int humanDigitIndex =0;

        char computerDigit = numberByComputer.charAt(computerDigitIndex);
        char humanDigit = numberByHuman.charAt(humanDigitIndex);

        //when
        Boolean expected = BaseBall.isBall(computerDigit,humanDigit,computerDigitIndex,humanDigitIndex);

        //then
        assertEquals(expected,false);


    }

}