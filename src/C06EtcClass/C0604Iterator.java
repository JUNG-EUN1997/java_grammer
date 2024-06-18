package C06EtcClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C0604Iterator {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("apple");
        myList.add("banana");
        myList.add("cherry");

//        enhanced for문 : 원본변경 불가
//        for (String a : myList) {
//            System.out.println(a);
//        }

//        iterator : 참조하고 있는 원본 데이트 삭제 가능 >> remove
        Iterator<String> iters = myList.iterator();

        while (iters.hasNext()){
//            System.out.println(iters.next()); // 소모하면서 꺼낸다.
            if (iters.next().equals("banana")) {
                iters.remove();
            }
        }

        System.out.println(myList);


    }
}
