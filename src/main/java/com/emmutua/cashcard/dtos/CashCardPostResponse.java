package com.emmutua.cashcard.dtos;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class CashCardPostResponse {
    private String id;
    private String message;
    public CashCardPostResponse(ObjectId id, String message) {
        this.id = id.toHexString();
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
