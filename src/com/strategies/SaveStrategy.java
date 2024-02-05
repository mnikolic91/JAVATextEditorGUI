package com.strategies;

import java.io.File;

public interface SaveStrategy {
    void save(File file, String content);
}
