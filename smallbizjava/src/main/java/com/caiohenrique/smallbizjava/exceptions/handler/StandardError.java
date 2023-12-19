package com.caiohenrique.smallbizjava.exceptions.handler;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class StandardError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long timestamp;
    private Integer status;
    private String message;
    private String error;
    private String path;

    public StandardError() {
        super();
    }

    public StandardError(Long timestamp, Integer status, String message, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.error = error;
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StandardError that = (StandardError) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(status, that.status) && Objects.equals(message, that.message) && Objects.equals(error, that.error) && Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, status, message, error, path);
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
