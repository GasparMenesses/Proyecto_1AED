package org.example.ConsoleManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BufferReader {
    BufferedReader br ;

    public BufferedReader BufferReader(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
        return br;
    }
}
