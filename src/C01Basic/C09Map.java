package C01Basic;

//import java.util.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class C09Map {
    public static void main(String[] args) {
//        Map<String, String> myMap = new HashMap<>();
//        myMap.put("basketball","농구");
//        myMap.put("soccer","축구");
//        myMap.put("baseball","야구");
////        System.out.println(myMap);
////        System.out.println(myMap.get("soccer"));
//        myMap.put("baseball","야호!");
//        myMap.remove("soccer");
////        System.out.println(myMap);
////        putIfAbsent : 비어있으면 put
//        myMap.putIfAbsent("basketball","배구");
//        getOrDefault : key가 없으면 default값 return
//        System.out.println(myMap.getOrDefault("baseball","비어있음"));
//        containsKey : 값이 있으면 key return
//        System.out.println(myMap.containsKey("baseb`all"));


//        농구 2 , 배구 2, 야구 1 로 출력하기
//        String[] arr = {"농구", "농구", "배구", "야구","배구"};
//        Map<String, Integer> myMap = new HashMap<>();
//        for (String a : arr){
////            방안 1
////            myMap.putIfAbsent(a, "0");
////            int count = Integer.parseInt(myMap.get(a));
////            myMap.put(a, String.valueOf((count+1)));
//
////            방안2
////            if(myMap.containsKey(a)){
////                myMap.put(a,myMap.get(a)+1);
////            }else{
////                myMap.put(a,1);
////            }
////            방안3
//            myMap.put(a, myMap.getOrDefault(a,0)+1);
//
//        }
//        Map<String, Integer> myMap = new HashMap<>();
//        myMap.put("key1",1);
//        myMap.put("key2",2);
//        myMap.put("key3",3);
////        iterator를 통해 key값 하나씩 출력
//        Iterator<String> myIter = myMap.keySet().iterator();
////        next()메서드는 데이터를 하나씩 소모시키면서 return
//        System.out.println(myIter.next());
////        hasNext() : iterator 안에 값이 있는지 boolean return
//        while (myIter.hasNext()){
//            System.out.println(myIter.next());
//        }

//        완주하지 못 한 선수 : 프로그래머스
//        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"stanko", "ana", "mislav"};
//        String answer = "";
//        Map<String,Integer> player = new HashMap<>();
//        for (String p : participant){
//            player.put(p,player.getOrDefault(p,0)+1);
//        }
//        for (String c : completion){
//            player.put(c, player.getOrDefault(c,0)-1);
//        }
//        Iterator<String> playerIter = player.keySet().iterator();
//        while (playerIter.hasNext()){
//            String thisPlayerKey = playerIter.next();
//            int failPlayerCount = player.get(thisPlayerKey);
//            System.out.println(failPlayerCount);
//            if(failPlayerCount > 0){
//                answer += thisPlayerKey;
//            }
//        }
//
//        System.out.println(answer);
//        System.out.println(player);


//        의상 : 프로그래머스
//        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
//        int answer = 0;


//        treeMap
//        Map<String,Integer> treeMap = new TreeMap<>();
//        treeMap.put("hellp",1);
//        treeMap.put("hellp2",2);
//        treeMap.put("hellp3",3);
//        treeMap.put("hellp4",4);
//        System.out.println(treeMap);


//        문자열 내 마음대로 정렬하기 : 프로그래머스
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        int count = 0;
        String[] answer = new String[strings.length];
        Map<String,String> strTreeMap = new TreeMap<>();
        for (int i = 0; i < strings.length; i++) {
            String newWord = strings[i].substring(n,n+1);
            strTreeMap.put(strings[i],newWord);
            System.out.println(newWord);
        }
        System.out.println(strTreeMap);
        Iterator<String> strIter = strTreeMap.keySet().iterator();
        while (strIter.hasNext()){
            String thisKey = strIter.next();
            answer[count] = thisKey;
            count++;
        }
        System.out.println(Arrays.toString(answer));


    }
}
