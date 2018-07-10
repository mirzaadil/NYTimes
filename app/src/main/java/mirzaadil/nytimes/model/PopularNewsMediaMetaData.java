
package mirzaadil.nytimes.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
/**
 * Created by Mirza Adil on 7/09/2018.
 *
 * This is a model class for popular News API.
 */
public class PopularNewsMediaMetaData implements Serializable {

    @SerializedName("url")
    private String url;

    @SerializedName("format")
    private String format;

    @SerializedName("height")
    private Integer height;

    @SerializedName("width")
    private Integer width;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

}
