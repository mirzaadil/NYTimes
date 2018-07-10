
package mirzaadil.nytimes.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mirza Adil on 7/09/2018.
 * <p>
 * This is a model class for popular News API.
 */

public class PopularNewsResponse implements Serializable {

    @SerializedName("status")
    private String status;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("num_results")
    private Integer numResults;


    @SerializedName("results")
    private List<PopularNews> popularArticles = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<PopularNews> getpopularArticles() {
        return popularArticles;
    }

    public void setpopularArticles(List<PopularNews> results) {
        this.popularArticles = results;
    }


}
