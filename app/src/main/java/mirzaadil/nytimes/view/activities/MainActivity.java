package mirzaadil.nytimes.view.activities;

import android.app.ProgressDialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mirzaadil.nytimes.R;
import mirzaadil.nytimes.controllers.interfaces.APIInterface;
import mirzaadil.nytimes.controllers.network.APIClient;
import mirzaadil.nytimes.controllers.utils.ApplicationConstant;
import mirzaadil.nytimes.controllers.utils.UtilityFunction;
import mirzaadil.nytimes.model.PopularNews;
import mirzaadil.nytimes.model.PopularNewsResponse;
import mirzaadil.nytimes.view.adapters.PopularNewsAdapter;
import retrofit2.Response;

/**
 * Created by Mirza Adil on 7/09/2018.
 * <p>
 * This is a Main Activity class show list of popular news .
 */
public class MainActivity extends AppCompatActivity {

    private APIInterface apiInterface;
    private List<PopularNews> popularNews;
    private RecyclerView recyclerViewPopuilarNews;
    private PopularNewsAdapter popularNewsAdapter;
    private LinearLayoutManager linearLayoutManager;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initializing the value.
        initView();

        if (UtilityFunction.isNetworkAvailable()) {

            UtilityFunction.showProgressDialog(progressDialog);


            //call popular news api.
            popularNewsApiCall();

        } else {

            UtilityFunction.showToast("Please connect Internet Connection");

        }


    }


    private void initView() {
        recyclerViewPopuilarNews = findViewById(R.id.rv_pouplar_news);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPopuilarNews.setLayoutManager(linearLayoutManager);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setMessage("Loading please wait...");
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
    }

    private void popularNewsApiCall() {
        apiInterface = APIClient.getClient().create(APIInterface.class);
        final Observable<Response<PopularNewsResponse>> locationdataCall = apiInterface.fetchNewsData(ApplicationConstant.BASE_URL + "all-sections/7.json?api-key=" + ApplicationConstant.API_KEY);
        System.out.println(locationdataCall);
        locationdataCall.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<PopularNewsResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(Response<PopularNewsResponse> value) {
                        if (value.isSuccessful()) {

                            UtilityFunction.dismissProgressDialog(progressDialog);

                            popularNews = value.body().getpopularArticles();

                            if (popularNews != null) {
                                popularNewsAdapter = new PopularNewsAdapter(popularNews, MainActivity.this);
                                recyclerViewPopuilarNews.setAdapter(popularNewsAdapter);
                            } else {
                                Toast.makeText(MainActivity.this, "Popular News Data Not Received ", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        UtilityFunction.dismissProgressDialog(progressDialog);
                        Toast.makeText(MainActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        UtilityFunction.dismissProgressDialog(progressDialog);
                    }
                });
    }

}
