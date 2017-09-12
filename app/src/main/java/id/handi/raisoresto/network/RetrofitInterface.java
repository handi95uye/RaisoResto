package id.handi.raisoresto.network;


import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import rx.Observable;

import id.handi.raisoresto.model.User;
import id.handi.raisoresto.model.Response;
/**
 * Created by handi on 11/09/2017.
 */

public interface RetrofitInterface {

    @POST("users")
    Observable<Response> register(@Body User user);


    @POST("authenticate")
    Observable<Response> login();

    @GET("users/{email}")
    Observable<User> getProfile(@Path("email") String email);

    @PUT("users/{email}")
    Observable<Response> changePassword(@Path("email") String email, @Body User user);

    @POST("users/{email}/password")
    Observable<Response> resetPasswordInit(@Path("email") String email);

    @POST("users/{email}/password")
    Observable<Response> resetPasswordFinish(@Path("email") String email, @Body User user);
}
