package com.studentinfo.models;

public class FileInfo {
    private String fileName;
    private String userName;

    public FileInfo() {
    }
    public FileInfo(String fileName, String userName) {
        this.fileName = fileName;
        this.userName = userName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
