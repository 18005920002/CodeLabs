package com.labs.algorithm.other;

import java.util.*;

/**
 * 按多个维度分类
 *
 * @author tanyun.zheng
 * @version v1.0 2019/3/8 9:46
 */
public class Classify {
    public static void main(String[] args) {
        /*List<Goods> goods = getGoods();
        Collections.sort(goods, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                int ret = o1.getColor().compareTo(o2.getColor());
                if(o1.getColor().equals(o2.getColor())){
                    ret = o1.getBatch().compareTo(o2.getBatch());
                    if(o1.getBatch().equals(o2.getBatch())){
                        ret = o1.getPriceLevel().compareTo(o2.getPriceLevel());
                    }
                }
                return  ret;
            }
        });
        for(Goods g : goods){
            System.out.println(g);
        }*/

        Set<String> set = new HashSet<>();
        set.add("AAA");
        set.add("BBB");
        set.add("CCC");
        set.add("DDD");
        set.add("EEE");
        System.out.println(getText(set));
    }

    public static List<Goods> getGoods(){
        List<Goods> goods = new ArrayList();
        goods.add(new Goods("red","1000","w2","p3","abc1234"));
        goods.add(new Goods("red","2000","w2","p3","abc1234"));
        goods.add(new Goods("red","3000","w2","p3","abc1234"));
        goods.add(new Goods("red","4000","w2","p3","abc1234"));
        goods.add(new Goods("blue","1000","w2","p3","abc1234"));
        goods.add(new Goods("blue","1000","w2","p3","abc1234"));
        goods.add(new Goods("blue","2000","w2","p3","abc1234"));
        goods.add(new Goods("green","1000","w2","p3","abc1234"));
        goods.add(new Goods("green","2000","w1","p4","abc1234"));
        goods.add(new Goods("red","2000","w2","p2","abc1234"));
        goods.add(new Goods("red","1000","w2","p3","abc1234"));
        goods.add(new Goods("orange","1000","w2","p3","abc1234"));
        goods.add(new Goods("gray","1000","w2","p3","abc1234"));
        goods.add(new Goods("gray","2000","w1","p1","abc1234"));
        goods.add(new Goods("red","1000","w2","p3","abc1234"));
        goods.add(new Goods("red","1000","w2","p3","abc1234"));
        goods.add(new Goods("red","1000","w2","p3","abc1234"));
        return goods;
    }




    private static String getText(Set<String> set){
        String t = "";
        int i=0;
        for(String s:set){
            t+=s+",";
            i++;
            if(i>=3){
                break;
            }
        }
        return t.substring(0,t.length()-1);
    }
}
