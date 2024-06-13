package C02ClassBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C0207RecurCombiPermu { //조합과 순열
    public static void main(String[] args) {
////        myList로 만들수 있는 2개짜리 숫자조합을 이중리스트에 담기
////        [[1,2], [1,3] [1,4], ...]

//        List<Integer>myList = new ArrayList<>(Arrays.asList(1,2,3,4));
//        List<List<Integer>> combinations = new ArrayList<>();
//
//        List<Integer> temp = new ArrayList<>();
//        for(int i=0; i<myList.size()-1; i++){
//            temp.add(myList.get(i));
//            System.out.println("temp i >> "+temp);
//            for(int j=i+1; j<myList.size(); j++){
//                temp.add(myList.get(j));
//                System.out.println("temp j >> "+temp);
//                combinations.add(new ArrayList<>(temp));
//                System.out.println(combinations);
//                System.out.println(temp);
//                System.out.println(myList.size());
//                temp.remove(temp.size()-1);
//            }
//            temp.remove(temp.size()-1);
//        }
//        System.out.println(combinations);
//
//        List<List<Integer>> combinations2 = new ArrayList<>();
//        for(int i=0; i<myList.size()-1; i++){
//            for(int j=i+1; j<myList.size(); j++){
//                List<Integer> temp2 = new ArrayList<>();
//                temp2.add(myList.get(i));
//                temp2.add(myList.get(j));
//                combinations2.add(new ArrayList<>(temp2));
//            }
//        }
//
//
//        System.out.println(combinations2);


//        List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
////        myList로 만들 수 있는 2개짜리 숫자조합을 이중리스트에 담기
//        List<List<Integer>> answer = new ArrayList<>();
//        combinations(answer, new ArrayList<>() , myList, 2, 0);
//        System.out.println(answer);


        List<Integer> myList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
//        myList로 만들 수 있는 2개짜리 숫자조합을 이중리스트에 담기
        List<List<Integer>> answer = new ArrayList<>();
        System.out.println(Arrays.toString(new boolean[myList.size()]));
        permutation(answer, new ArrayList<>() , myList, 2, 0, new boolean[myList.size()]);
        System.out.println(answer);
        System.out.println("으잉");
    }

    static void combinations(List<List<Integer>> answer, List<Integer>temp, List<Integer> myList, int count, int start) {
        if(temp.size() == count){
            System.out.println(temp);
//            temp의 메모리값이 add되기 때문에, temp의 변경값도 함께 참조된다. 그것을 방지하기 위해 new ArrayList로 할당해야한당
//            answer.add(temp); // 이렇게 하지 않는 이유는 ...해서 완전복사를 해야하는 의미와 비슷하다고 생각~
            answer.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            combinations(answer, temp, myList, count, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

//    순열 : 중복된 숫자
    static void permutation(List<List<Integer>> answer, List<Integer>temp, List<Integer> myList, int count, int start, boolean[] visited) {
        if(temp.size() == count){
//            temp의 메모리값이 add되기 때문에, temp의 변경값도 함께 참조된다. 그것을 방지하기 위해 new ArrayList로 할당해야한당
//            answer.add(temp); // 이렇게 하지 않는 이유는 ...해서 완전복사를 해야하는 의미와 비슷하다고 생각~
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if(visited[i] == false){
                visited[i] = true;
                temp.add(myList.get(i));
                permutation(answer, temp, myList, count, i + 1, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }


}


