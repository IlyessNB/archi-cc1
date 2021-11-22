package fr.esgi.archi.cc1.repository;

public final class UserId {

    private final int value;

    private UserId(int value) {
        this.value = value;
    }

    public static UserId of(int value){
        return new UserId(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }
}