package Singleton;

/**
 * @author Jugram Chen
 * @create 2020-08-23 18:57
 */
public class Eager {//饿汉式
    public static final Eager INSTANCE=new Eager();//静态常量
    private Eager(){
        //私有化构造器
    }
}
//public enum Singleton02{//枚举类实现单例
//    INSTANCE;//默认为静态常量
//}

