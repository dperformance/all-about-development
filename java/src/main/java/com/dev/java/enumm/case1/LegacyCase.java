package com.dev.java.enumm.case1;


/**
 * 매일 배치를 돌며 하나의 테이블(테이블명 : origin)에 있는 내용을 2개의 테이블 (테이블명 : table1, table2)에 등록하는 기능이 있다.
 * 문제가 됐던 것은 origin 테이블의 값은 "Y", "N"인데, table1, tabl2는 "1"/"0", true/false 형태인 것이다.
 */
public class LegacyCase {
    public String toTable1Value(String originValue) {
        return "y".equals(originValue) ? "1" : "0";
    }

    public boolean table2Value(String originValue) {
        return "Y".equals(originValue);
    }

    /**
     * 기능상의 문제는 없지만, 몇가지 문제가 있다.
     *  - "Y", "1", true는 모두 같은 의미라는 것을 알 수 있다.
     *      - Y란 값은 "1"이 될 수도 있고, true가 될 수도 있다는 것을 확인하려면 항상 위에서 선언된 클래스와 메소드를 찾아야 한다.
     *  - 불필요한 코드량이 많다.
     *      - Y, N외에 R, S 등의 추가 값이 필요한 경우 if문을 포함한 메소드 단위로 코드가 증가하게 된다.
     *      - 동일한 타입의 값이 추가되는것에 비해 너무 많은 반복성 코드가 발생하게 된다.
     *
     *  이 부분을 Enum(TableStatus) 으로 추출한다.
     */

}
