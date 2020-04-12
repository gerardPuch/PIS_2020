package edu.ub.pis2020.gpuchcam7.mhealth.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Articles {

    @SerializedName("Source")
    @Expose
    var source: Source = Source()

    @SerializedName("author")
    @Expose
    var author: String = ""

    @SerializedName("title")
    @Expose
    var title: String = ""

    @SerializedName("description")
    @Expose
    var description: String = ""

    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String = ""

    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String = ""

    public fun getsource(): Source{
        return source
    }
    public fun setsource(new: Source){
        source = new
    }

    public fun getauthor(): String{
        return author
    }
    public fun setauthor(new: String){
        author = new
    }

    public fun gettitle(): String{
        return title
    }
    public fun settitle(new: String){
        title = new
    }

    public fun getdescription(): String{
        return description
    }
    public fun setdescription(new: String){
        description = new
    }

    public fun geturlToImage(): String{
        return urlToImage
    }
    public fun seturlToImage(new: String){
        urlToImage = new
    }

    public fun getpublishedAt(): String{
        return publishedAt
    }
    public fun setpublishedAt(new: String){
        publishedAt = new
    }
}