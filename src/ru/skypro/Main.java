package ru.skypro;

public class Main {

    public static void main(String[] args) {
        boolean result = Service.user("java_skypro", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        if (result) {
            System.out.println("Login и Password корректны");
        }
    }
}
