package com.alibaba.csp.sentinel.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.demo.dubbo.FooService;

import org.apache.dubbo.config.annotation.Service;

/**
 * @author Eric Zhao
 */
@Service
public class FooServiceImpl implements FooService {

    @SentinelResource(value = "sayHello")
    @Override
    public String sayHello(String name) {
        return "Hello, " + name;
    }

    @Override
    public long getCurrentTime(boolean slow) {
        // Simulate slow invocations randomly.
        if (slow) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
        return System.currentTimeMillis();
    }
}
