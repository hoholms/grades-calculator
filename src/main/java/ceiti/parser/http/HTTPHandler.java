package ceiti.parser.http;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HTTPHandler {

    public enum ResponseCode{
        SUCCESS,
        CONNECTION_TIMEOUT,
        CALL_TIMEOUT,
        WRONG_IDNP
    }
    private static Document responseDocument;

    /**
     * Before we can request a Document with grades, we have to get the required cookies from the server.
     * To do that, we send a request with IDNP, and if it is found in the DB, we will receive 2 cookies.
     * Otherwise, we will receive a different amount of cookies which will indicate that IDNP was incorrect.
     * @param client a client which will be used to make a request
     * @param body a body to put in the request, which should contain IDNP field
     * @return list of cookies, if the request was successful, otherwise null
     * @throws IOException if Call.execute() throws an exception
     */
    private static List<String> executeCookiesRequest(OkHttpClient client, RequestBody body) throws IOException{
        Request cookieRequest = new Request.Builder()
                .url("https://api.ceiti.md/date/login")
                .method("POST", body)
                .build();

        List<String> cookies = null;
        try (Response cookieResponse = client.newCall(cookieRequest).execute()) {
            if (cookieResponse.networkResponse() != null && cookieResponse.networkResponse().code() == 302) {
                cookies = cookieResponse.headers("Set-Cookie");
            }
        }
        return cookies;
    }

    /**
     * This method should be called after we receive cookies, otherwise the server will decline our request.
     * If this request is successful, a Document with grades will be saved in the responseDocument field.
     * @param client a client which will be used to make a request
     * @param idnp IDNP, which will be concatenated to the URL
     *             (should be the same IDNP which was used to receive cookies)
     * @param cookie a cookies, which server expects in the next request
     * @throws IOException if Call.execute() throws an exception
     */
    private static void executeGradesDocumentRequest(OkHttpClient client, String idnp, String cookie) throws IOException{
        Request gradesRequest = new Request.Builder()
                .url("https://api.ceiti.md/index.php/date/info/" + idnp)
                .method("GET", null)
                .addHeader("Cookie", cookie)
                .build();

        try (Response lastResponse = client.newCall(gradesRequest).execute()) {
            if (lastResponse.networkResponse() != null && lastResponse.networkResponse().code() == 200
                    && lastResponse.body() != null) {
                responseDocument = Jsoup.parse(lastResponse.body().string());
            }
        }
    }

    /**
     *
     * @param idnp IDNP of a person whose grades we want to request
     * @return ResponseCode which will indicate, whether the request was successful or not
     * @throws IOException if unexpected behaviour occurs
     */
    public static ResponseCode getHTMLDocument(@NotNull String idnp) throws  IOException{
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .callTimeout(8000, TimeUnit.MILLISECONDS)
                .followRedirects(false)
                .build();

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("idnp",idnp)
                .build();

        try{
            List<String> cookies = executeCookiesRequest(client, body);
            if(cookies == null || cookies.size() != 2) return ResponseCode.WRONG_IDNP;

            //we have to specifically get the second cookie,
            //because this is the cookie the server returns and expects in the next request
            executeGradesDocumentRequest(client, idnp, cookies.get(1));

            if (responseDocument == null) return ResponseCode.WRONG_IDNP;

            return ResponseCode.SUCCESS;
        }
        catch(SocketTimeoutException e){
            return ResponseCode.CONNECTION_TIMEOUT;
        }
        catch(InterruptedIOException e){
            return ResponseCode.CALL_TIMEOUT;
        }
    }

    /**
     * This method should be called after a successful request, because only such a request returns a Document.
     * @return Document with grades, if there was any successful request, otherwise null
     */
    public static Document getGradesDocument(){
        return responseDocument;
    }

}
