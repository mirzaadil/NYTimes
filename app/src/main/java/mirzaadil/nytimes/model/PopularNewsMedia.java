
package mirzaadil.nytimes.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
/**
 * Created by Mirza Adil on 7/09/2018.
 *
 * This is a model class for popular News API.
 */
public class PopularNewsMedia implements Serializable {

    @SerializedName("type")
    private String type;

    @SerializedName("subtype")
    private String subtype;

    @SerializedName("caption")
    private String caption;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("approved_for_syndication")
    private int approvedForSyndication;

    @SerializedName("media-metadata")
    private List<PopularNewsMediaMetaData> mediaMetadata = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(int approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public List<PopularNewsMediaMetaData> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<PopularNewsMediaMetaData> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

}
