package com.example.bitp6;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailArticle extends AppCompatActivity {
    public TextView txtDetailTitle, txtDetailViews, txtDetailContent;
    public ImageView imgDetail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_article);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtDetailTitle = findViewById(R.id.txtDetailTitle);
        txtDetailViews = findViewById(R.id.txtDetailViews);
        txtDetailContent = findViewById(R.id.txtDetailContent);
        imgDetail = findViewById(R.id.imgDetail);

        /*nhận vị trí của bài viết*/
        int position = getIntent().getIntExtra("position", -1);

        /*check position*/
        if (position >= 0 && position < Main2.articlelist.size()) {

        Article article = Main2.articlelist.get(position);


        /*Hiển thị ảnh*/
            imgDetail.setImageResource(article.getImgcover());
        /*Hiển thị tiêu đề*/
            txtDetailTitle.setText(article.getTitle());
        /*Hiển thị nội dung bài viết*/
             txtDetailContent.setText(article.getContent());
        /*  Hiển thị lượt view*/
             txtDetailViews.setText("lượt xem: " + article.getViews());
        /* Tăng lượt view*/
        article.setViews(article.getViews()+1);

}
        /*int resId = getResources()
                .getIdentifier(article.getImgcover(), "drawable", getPackageName());
        if (resId == 0) resId = android.R.drawable.ic_menu_report_image;
        imgDetail.setImageResource(resId);*/
    }
}