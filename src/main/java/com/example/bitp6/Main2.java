package com.example.bitp6;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main2 extends AppCompatActivity {
    private RecyclerView recyclerArticle;
    public static List<Article> articlelist = new ArrayList<>();
    private ArticleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        articlelist.clear();
        /*bai 1*/
        articlelist.add(new Article(
                "Mèo bị giảm bạch cầu nên ăn - kiêng gì để nhanh khỏi bệnh?",
                "Mèo bị giảm bạch cầu quan trọng phải đảm bảo chế độ ăn phù hợp, tìm hiểu thêm cách mèo bị giảm bạch cầu nên ăn gì cùng PETKIT by HeLiCorp...",
                R.drawable.img_news1,0));

        /*bai 2*/
        articlelist.add(new Article(
                "Máy cho ăn tự động thú cưng",
                "Bạn quá bận rộn, không có thời gian cho thú cưng ăn. Vậy thì, máy cho ăn tự động chính là giải pháp hữu ích mà bạn có thể xem xét. Cùng HeLiPet điểm danh... ",
                R.drawable.img_news2,0));

        /*bai 3*/
        articlelist.add(new Article(
                "Các cách trị rụng lông mèo hiệu quả tại nhà",
                "Mọi nơi trong nhà phủ đầy lông mèo và \"sen\" không biết có cách trị rụng lông mèo nào hiệu quả không, cùng xem một số bí quyết đơn giản có thể làm tại nhà.",
                R.drawable.img_news3,0));


        ///tạo Apdapter
        adapter = new ArticleAdapter(articlelist);
        ///hiển thị danh sách
        recyclerArticle = findViewById(R.id.recyclerArticle);
        recyclerArticle.setLayoutManager(
                new LinearLayoutManager(this)
        );
        ///gắn adapter
        recyclerArticle.setAdapter(adapter);
        ///click vào bài
        adapter.setOnItemClickListener(position -> {
            Intent intent = new Intent(
                    Main2.this, DetailArticle.class
            );


        ///truyền vị trí bài viết
        intent.putExtra("position",position);
        startActivity(intent);
        });
    }
    @SuppressLint("NotifyDataSetChanged")
    @Override
        protected void onResume(){
            super.onResume();
            if (adapter != null){
                adapter.notifyDataSetChanged();
        }
    }
}