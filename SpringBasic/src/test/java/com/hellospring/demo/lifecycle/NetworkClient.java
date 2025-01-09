package com.hellospring.demo.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, URL = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스를 시작할 때 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + " message = " + message);
    }

    // 서비스가 종료될 때 호출
    public void disconnect() {
        System.out.println("close : " + url);
    }

    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        disconnect();
    }
}
