package com.nilesh.educora;

public class Posts {
    String ids,title,content;

    public Posts() {
    }

    public Posts(String ids, String title, String content) {
        this.ids = ids;
        this.title = title;
        this.content = content;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
