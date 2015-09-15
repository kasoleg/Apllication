package net.neutrinosoft.application;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import net.neutrinosoft.application.models.News;

/**
 * Created by Oleg Kasyanov on 9/15/2015.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    Context context;
    private List<News> newsList;

    public NewsAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        this.context = context;
        this.newsList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder viewHolder;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_news, parent, false);
            viewHolder = new ViewHolder(row);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) row.getTag();
        }

        News news = newsList.get(position);
        viewHolder.tvNews.setText(news.getDescription());
        //установка изображения
        return row;
    }

    class ViewHolder {
        TextView tvNews;
        ImageView ivNews;
        TextView tvCreatedAt;
        ViewHolder(View view) {
            tvNews = (TextView) view.findViewById(R.id.tvNews);
            ivNews = (ImageView) view.findViewById(R.id.ivNews);
        }
    }
}
