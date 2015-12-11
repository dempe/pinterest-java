package com.chrisdempewolf.responses;

import com.google.gson.annotations.SerializedName;
import com.chrisdempewolf.responses.pin.Data;

public class ErrorResponse {
    private final String status;
    private final int code;
    private final String host;

    @SerializedName("generated_at")
    private final String generatedAt;
    private final String message;
    private final Data data;

    public ErrorResponse(String status, int code, String host, String generatedAt, String message, Data data) {
        this.status = status;
        this.code = code;
        this.host = host;
        this.generatedAt = generatedAt;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public String getHost() {
        return host;
    }

    public String getGeneratedAt() {
        return generatedAt;
    }

    public String getMessage() {
        return message;
    }

    public Data getData() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorResponse that = (ErrorResponse) o;

        if (code != that.code) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (host != null ? !host.equals(that.host) : that.host != null) return false;
        if (generatedAt != null ? !generatedAt.equals(that.generatedAt) : that.generatedAt != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        return !(data != null ? !data.equals(that.data) : that.data != null);

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + code;
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (generatedAt != null ? generatedAt.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", host='" + host + '\'' +
                ", generatedAt='" + generatedAt + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
