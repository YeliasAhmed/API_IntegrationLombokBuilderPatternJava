package services;

import lombok.Getter;

public class ErrorMessage {
    @Getter private String message;

    public int getCode() {
        return 400;
    }

    public int getStatus() {
        return 400;
    }
}
