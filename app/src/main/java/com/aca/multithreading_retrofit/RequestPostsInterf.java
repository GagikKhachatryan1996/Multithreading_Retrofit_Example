package com.aca.multithreading_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RequestPostsInterf {

    @GET("posts")
    Call<List<PostModel>> getPosts();

    @POST("posts")
    Call<PostModel> createPosts(@Body PostModel postModel);

    @PUT("posts/{id}")
    Call<PostModel> putPosts(@Path("id") int id,@Body PostModel postModel);

    @PATCH("posts/{id}")
    Call<PostModel> patchPosts(@Path("id") int id,@Body PostModel postModel);

    @DELETE("posts/{id}")
    Call<Void> deletePosts(@Path("id") int id);








}
