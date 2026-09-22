package com.example.bitp6;

public class Article {
    private String title;
    private String content;
    private int views;
    private int imgcover;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_artical_layout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

    public Article(String title, String content, int imgcover, int views) {
        this.title = title;
        this.content = content;
        this.views = views;
        this.imgcover = imgcover;
    }

    /*constructor*/

    /// title
    public String getTitle() {
        return title;
    }
//    public void setTitle (String title)
//    {
//        this.title=title;
//    }

    /// content
    public String getContent() {
        return content;
    }
    /*public void setContent(String content)
    {this.content=content;}*/

    /// image
    public int getImgcover() {
        return imgcover;
    }
    /*public void setImgCover(String imgCover)
    {this.imgcover=imgCover;}*/

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

}