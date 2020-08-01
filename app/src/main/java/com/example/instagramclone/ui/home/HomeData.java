package com.example.instagramclone.ui.home;

public class HomeData {
    public int user_profile;
    public String upload_title;
    public int upload_image;

    public String liking;
    public String user_id;
    public String comment_context;
    public String hash_tag;

    public HomeData(int user_profile, String upload_title, int upload_image, String liking, String user_id, String comment_context, String hash_tag) {
        this.user_profile = user_profile;
        this.upload_title = upload_title;
        this.upload_image = upload_image;

        this.liking = liking;
        this.user_id = user_id;
        this.comment_context = comment_context;
        this.hash_tag = hash_tag;
    }

}
