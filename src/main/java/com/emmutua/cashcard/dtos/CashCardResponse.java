package com.emmutua.cashcard.dtos;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CashCardResponse {
    private String  exId;
    private String message;
    public CashCardResponse(ObjectId id, String message) {
        this.exId = id.toHexString();
        this.message = message;
    }

    public String getExId() {
        return exId;
    }

    public void setExId(String exId) {
        this.exId = exId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
