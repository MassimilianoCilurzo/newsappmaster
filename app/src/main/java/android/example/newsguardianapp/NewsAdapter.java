package android.example.newsguardianapp;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, ArrayList<News> object) {
        super(context, 0, object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // ViewHolder object.
        ViewHolder holder;

        // Check if the existing view is being reused, otherwise inflate the view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
            holder = new ViewHolder();
            holder.sectionTextView = convertView.findViewById(R.id.section);
            holder.titleTextView = convertView.findViewById(R.id.title);
            holder.dateTextView = convertView.findViewById(R.id.date);
            holder.authorTextView = convertView.findViewById(R.id.author);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the News object located at this position in the list.
        News currentNews = getItem(position);
        // Create a new Date object from the time in ISO-8601 format of the news.
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date dateObject = null;
        try {
            dateObject = simpleDateFormat.parse(currentNews.getPublicationDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // Format the date string (i.e. "Mar 3, 1984").
        String formattedDate = formatDate(dateObject);


        // Set proper data in list_item by using ViewHolder.
        holder.sectionTextView.setText(currentNews.getSectionName());
        holder.titleTextView.setText(currentNews.getWebTitle());
        holder.dateTextView.setText(formattedDate);
        holder.authorTextView.setText(currentNews.getAuthor());


        return convertView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     *
     * @param dateObject is the time of news in ISO-8601 format.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getDefault());
        return dateFormat.format(dateObject);
    }

    /**
     * This ViewHolder class is help to represent data in ListView by recycling.
     */
    static class ViewHolder {

        private TextView sectionTextView;
        private TextView titleTextView;
        private TextView dateTextView;
        private TextView authorTextView;

    }
}