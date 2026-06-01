package org.example.tliaswebmanagement;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBack {
    private static final Logger log = LoggerFactory.getLogger(LogBack.class);

    @Test
    void test(){
        log.debug("-----开始计数------");
        int num = 0;
        for(int i=0;i<100;i++){
            num += i;
        }
        log.info("计算结果为"+num);
        log.debug("------结束计数------");
    }
}
