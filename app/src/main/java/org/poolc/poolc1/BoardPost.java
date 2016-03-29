package org.poolc.poolc1;

import org.json.JSONException;
import org.json.JSONObject;

public class BoardPost {
    private String title;
    private String writer;
    private String content;
    private String time;

    public String getTitle() { return this.title; }
    public String getWriter() { return this.writer; }
    public String getContent() { return this.content; }
    public String getTime() { return this.time; }

    public BoardPost(JSONObject object) {
        try {
            this.title = object.getString("title");
            this.writer = object.getString("writer");
            this.content = object.getString("content");
            this.time = object.getString("time");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
