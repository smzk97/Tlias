package org.example.tliaswebmanagement.Utils;


// 在线程中设置变量
public class ThreadLocalUtil {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public static void setCurrentId(Object id){
        THREAD_LOCAL.set(id.toString());
    }

    public static Object getCurrentId(){
        return THREAD_LOCAL.get();
    }

    public static void removeCurrentId(){
        THREAD_LOCAL.remove();
    }

}
