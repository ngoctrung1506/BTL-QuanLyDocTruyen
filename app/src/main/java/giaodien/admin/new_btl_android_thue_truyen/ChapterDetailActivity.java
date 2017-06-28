package giaodien.admin.new_btl_android_thue_truyen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChapterDetailActivity extends AppCompatActivity {
   private TextView txtND;
    SQLiteManga sqLiteManga = new SQLiteManga(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapterdetail);
        txtND = (TextView) findViewById(R.id.txtND);
        final Intent intent = getIntent();
        String name = intent.getExtras().getString("NAME");
        Manga manga = sqLiteManga.findMangabyName(name);
      try {
            FileInputStream in= openFileInput(manga.getNdchuong()+".txt");
            BufferedReader reader=new
                BufferedReader(new InputStreamReader(in));
            String data="";
            StringBuilder builder=new StringBuilder();
            while((data=reader.readLine())!=null)
            {
                builder.append(data);
                builder.append("\n");
            }
            in.close();
            txtND.setText(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
