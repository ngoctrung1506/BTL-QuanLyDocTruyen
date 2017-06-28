package giaodien.admin.new_btl_android_thue_truyen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 19/04/2017.
 */

public class MangaAdapter extends RecyclerView.Adapter<MangaAdapter.MangaViewHolder> {

    private ArrayList<Manga> mangaArrayList;
    private LayoutInflater mLayoutInflater;
    private ClickImage clickImage;


    public MangaAdapter(ClickImage clickImage , LayoutInflater layoutInflater, ArrayList<Manga> datas) {
        this.clickImage = clickImage;
        mangaArrayList = datas;
        mLayoutInflater = layoutInflater;
    }

    @Override
    public MangaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = mLayoutInflater.inflate(R.layout.manga_layout, parent, false);
        return new MangaViewHolder(itemView);

    }


    @SuppressWarnings("ResourceType")
    @Override
    public void onBindViewHolder(MangaViewHolder holder, int position) {
        Manga manga = mangaArrayList.get(position);

        String tacGia;
        if(manga.getTacGia().length()>16){
            tacGia = manga.getTacGia().substring(0,15) + "...";
        }
        else tacGia = manga.getTacGia();
        holder.txtTacGia.setText(tacGia);
        holder.txtTenTruyen.setText(manga.getTen());
        holder.imgManga.setImageResource(manga.getImage());

    }

    @Override
    public int getItemCount() {
        return mangaArrayList.size();
    }

    class MangaViewHolder extends RecyclerView.ViewHolder{
        private ImageButton imgManga;
        private TextView txtTacGia;
        private TextView txtTenTruyen;

        public MangaViewHolder(View itemView) {
            super(itemView);
            imgManga = (ImageButton) itemView.findViewById(R.id.imgManga);
            txtTacGia = (TextView) itemView.findViewById(R.id.txtTacGia);
            txtTenTruyen = (TextView) itemView.findViewById(R.id.txtTenTruyen);
            imgManga.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    clickImage.onClick(txtTenTruyen.getText().toString());
                }
            });
        }
    }

}

interface ClickImage {
    void onClick(String tentruyen);
}