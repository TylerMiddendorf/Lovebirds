package com.lovebirds;

public class FactoryProducer {
    
    public MySQLFactory geSQLFactory() {
        return new MySQLFactory();
    }
}


