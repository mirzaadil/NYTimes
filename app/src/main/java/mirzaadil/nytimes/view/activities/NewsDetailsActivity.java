package mirzaadil.nytimes.view.activities;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import mirzaadil.nytimes.R;

/**
 * Created by Mirza Adil on 7/09/2018.
 * <p>
 * This is a news detail class show detail .
 */

public class NewsDetailsActivity extends AppCompatActivity {

    private SimpleDraweeView simpleDraweeView;
    private TextView textView_title;
    private TextView textView_abstract;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

//   Initializing the value.
        initView();


    }


    private void initView() {

        simpleDraweeView = findViewById(R.id.imageView_user_detail);
        textView_title = findViewById(R.id.textview_title_detail);
        textView_abstract = findViewById(R.id.textview_abstract_detail);

        Uri imageUri = Uri.parse(getIntent().getStringExtra("imageUri"));
        simpleDraweeView.setImageURI(imageUri);
        textView_title.setText(getIntent().getStringExtra("title"));
        textView_abstract.setText(getIntent().getStringExtra("abstract"));
    }
}
