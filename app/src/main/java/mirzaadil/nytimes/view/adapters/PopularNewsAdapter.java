package mirzaadil.nytimes.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import mirzaadil.nytimes.R;
import mirzaadil.nytimes.model.PopularNews;
import mirzaadil.nytimes.view.activities.MainActivity;
import mirzaadil.nytimes.view.activities.NewsDetailsActivity;

/**
 * Created by Mirza Adil on 7/09/2018.
 * <p>
 * This is a popular new adapter class .
 * This class will feature the implementation of the Recycler Adapter for popular news recycler.
 */

public class PopularNewsAdapter extends RecyclerView.Adapter<PopularNewsAdapter.PopularNewsViewHolder> {
    private List<PopularNews> popularNews;
    private Context context;


    public PopularNewsAdapter(List<PopularNews> popularNews, MainActivity context) {
        this.popularNews = popularNews;
        this.context = context;
    }


    @NonNull
    @Override
    public PopularNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.populer_news_view_item, parent, false);
        return new PopularNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PopularNewsViewHolder holder, final int position) {

        holder.textViewAbstract.setText(popularNews.get(position).getAbstract());
        holder.textView_ByLine.setText(popularNews.get(position).getByline());
        holder.textView_Soruce.setText(popularNews.get(position).getSource());
        holder.textView_Date.setText(popularNews.get(position).getPublishedDate());
        holder.ImageView(popularNews.get(position), position, holder);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                holder.DetailScrrrn(popularNews.get(position), position);
            }
        });
    }


    @Override
    public int getItemCount() {
        return popularNews.size();
    }

    class PopularNewsViewHolder extends RecyclerView.ViewHolder {


        private TextView textViewAbstract;
        private ImageView imageView_user;
        private TextView textView_ByLine;
        private TextView textView_Soruce;
        private TextView textView_Date;


        public PopularNewsViewHolder(View itemView) {
            super(itemView);
            textViewAbstract = itemView.findViewById(R.id.textview_abstract);
            imageView_user = itemView.findViewById(R.id.imageView_user);
            textView_ByLine = itemView.findViewById(R.id.textviewByLine);
            textView_Soruce = itemView.findViewById(R.id.textviewSource);
            textView_Date = itemView.findViewById(R.id.textviewDate);
        }


        private void ImageView(Object obj, final int position, PopularNewsViewHolder holder) {

            // Checking the holder instance type.

            if (obj instanceof PopularNews) {
                PopularNews news = (PopularNews) obj;
                if (!TextUtils.isEmpty(news.getMedia().get(0).getMediaMetadata().get(0).getUrl())) {
                    Uri imageUri = Uri.parse(news.getMedia().get(0).getMediaMetadata().get(0).getUrl());
                    SimpleDraweeView draweeView = (SimpleDraweeView) holder.imageView_user;
                    draweeView.setImageURI(imageUri);
                    int color = Color.GRAY;
                    RoundingParams roundingParams = RoundingParams.fromCornersRadius(5f);
                    roundingParams.setBorder(color, 1.0f);
                    roundingParams.setRoundAsCircle(true);
                    draweeView.getHierarchy().setRoundingParams(roundingParams);

                }

            }
        }


        private void DetailScrrrn(Object obj, final int position) {

            if (obj instanceof PopularNews) {
                PopularNews data = (PopularNews) obj;
                if (!TextUtils.isEmpty(data.getMedia().get(0).getMediaMetadata().get(0).getUrl())) {
                    Uri imageUri = Uri.parse(data.getMedia().get(0).getMediaMetadata().get(0).getUrl());

                    Intent intent = new Intent(context, NewsDetailsActivity.class);

                    intent.putExtra("title", popularNews.get(position).getTitle());
                    intent.putExtra("abstract", popularNews.get(position).getAbstract());
                    intent.putExtra("imageUri", data.getMedia().get(0).getMediaMetadata().get(0).getUrl());

                    context.startActivity(intent);
                }
            }
        }
    }
}
