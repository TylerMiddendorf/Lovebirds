package com.lovebirds;

public class FactoryProducer {
    
    public static MySQLFactory getSQLFactory() {
        return new MySQLFactory();
    }
}


