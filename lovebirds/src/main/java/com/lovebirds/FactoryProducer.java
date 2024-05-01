package com.lovebirds;

public class FactoryProducer {
    
    public MySQLFactory geSqlFactory() {
        return new MySQLFactory();
    }
}


