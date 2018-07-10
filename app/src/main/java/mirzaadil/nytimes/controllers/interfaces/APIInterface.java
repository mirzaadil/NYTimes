package mirzaadil.nytimes.controllers.interfaces;

import io.reactivex.Observable;
import mirzaadil.nytimes.model.PopularNewsResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Url;


/**
 * Created by Mirza Adil on 7/09/2018.
 * <p>
 * This class contains the API Interface of the API.
 * All of the attributes in this class shall be static. So, that they can be used from anywhere
 * without even declaring the object of this class.
 * </p>
 */

public interface APIInterface {


    @GET
    Observable<Response<PopularNewsResponse>> fetchNewsData(@Url String url);
}
