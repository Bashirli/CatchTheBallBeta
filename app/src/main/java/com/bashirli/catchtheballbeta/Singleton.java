package com.bashirli.catchtheballbeta;

public class Singleton {
    private data data_level;
    private static Singleton singleton;

    private Singleton(){

    }

    public void setData_level(data data_level) {
        this.data_level = data_level;
    }

    public data getData_level() {
        return data_level;
    }

    public static Singleton getSingleton() {
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
