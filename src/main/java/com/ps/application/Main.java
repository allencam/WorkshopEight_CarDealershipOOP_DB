package com.ps.application;

public class Main {
    public static void main(String[] args) {
        String user = args[0];
        String pass = args[1];

        UserInterface.display(user,pass);
    }
}