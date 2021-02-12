package com.shristi.myapplication.Chat;

class InstantMessage {
    private String message;
    private  String author;

    public InstantMessage() {
    }

    public InstantMessage(String message, String author) {
        this.message = message;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }



    public String getAuthor() {
        return author;
    }


}