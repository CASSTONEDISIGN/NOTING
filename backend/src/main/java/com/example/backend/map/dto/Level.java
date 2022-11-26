package com.example.backend.map.dto;

public enum Level {

    // 단위: M
    LEVEL1(100),
    LEVEL2(200),
    LEVEL3(400),
    LEVEL4(800),
    LEVEL5(1600);

    private final int level;

    Level(int level) {
        this.level = level;
    }

    public int level(){
        return level;
    }
}
