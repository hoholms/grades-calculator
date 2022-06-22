package ceiti.parser.http;

import java.util.*;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HTTPHandler {

    public enum ResponseCode{
        SUCCESS,
        TIMEOUT, //TODO add timeout verification
        WRONG_INPUT
    }
    private static Response lastResponse;
    public static ResponseCode getHTMLDocument(@NotNull String idnp) throws  IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(8000, TimeUnit.MILLISECONDS)
                .followRedirects(false)
                .build();


        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("idnp",idnp)
                .build();

        Request cookieRequest = new Request.Builder()
                .url("https://api.ceiti.md/date/login")
                .method("POST", body)
                .build();

        Response cookieResponse = client.newCall(cookieRequest).execute();

        if(cookieResponse.networkResponse().code() != 302) return ResponseCode.WRONG_INPUT;

        List<String> cookies = cookieResponse.headers("Set-Cookie");

        //TODO check cookies size; throw exception if not 2
        if(cookies.size() != 2) return ResponseCode.WRONG_INPUT;
        Request gradesRequest = new Request.Builder()
                .url("https://api.ceiti.md/index.php/date/info/" + idnp)
                .method("GET", null)
                .addHeader("Cookie", cookies.get(1))
                .build();


        lastResponse = client.newCall(gradesRequest).execute();
        if (lastResponse.networkResponse().code() != 200) return ResponseCode.WRONG_INPUT;

        return ResponseCode.SUCCESS;
    }

    public static Response getLastResponse(){
        return lastResponse;
    }

}
