package com.aca.multithreading_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.text);

        thread.setPriority(5);
        thread2.setPriority(3);
        thread4.setPriority(1);
        thread5.setPriority(4);
        thread3.setPriority(2);


        thread.start();
        thread2.start();
        thread4.start();
        thread5.start();
        thread3.start();


    }

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RequestPostsInterf requestPostsInterf = retrofit.create(RequestPostsInterf.class);

            Call<List<PostModel>> listCall = requestPostsInterf.getPosts();

            listCall.enqueue(new Callback<List<PostModel>>() {
                @Override
                public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {

                    Toast.makeText(MainActivity.this, "Get Succes", Toast.LENGTH_SHORT).show();

                    List<PostModel> postModels = response.body();

                    for (PostModel p : postModels) {


                        int userid = p.getUserId();
                        int id = p.getId();
                        String title = p.getTitle();
                        String body = p.getBody();

                        text.append(userid + "\n" + id + "\n" + title + "\n" + body + "\n");

                    }

                }

                @Override
                public void onFailure(Call<List<PostModel>> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Get Failure", Toast.LENGTH_SHORT).show();

                }
            });


        }
    });


    Thread thread2 = new Thread(new Runnable() {
        @Override
        public void run() {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            RequestPostsInterf requestPostsInterf2 = retrofit.create(RequestPostsInterf.class);


            PostModel myPostModel = new PostModel(10, 100, "Hello World", "Good By");


            Call<PostModel> call = requestPostsInterf2.createPosts(myPostModel);

            call.enqueue(new Callback<PostModel>() {
                @Override
                public void onResponse(Call<PostModel> call, Response<PostModel> response) {

                    Toast.makeText(MainActivity.this, "Post Succes", Toast.LENGTH_SHORT).show();

                    PostModel postModel = response.body();


                    int userid = postModel.getUserId();
                    int id = postModel.getId();
                    String title = postModel.getTitle();
                    String body = postModel.getBody();

                    text.append(userid + "\n" + id + "\n" + title + "\n" + body + "\n");


                }

                @Override
                public void onFailure(Call<PostModel> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Post Failure", Toast.LENGTH_SHORT).show();

                }
            });


        }
    });


    Thread thread3 = new Thread(new Runnable() {
        @Override
        public void run() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


            RequestPostsInterf requestPostsInterf3 = retrofit.create(RequestPostsInterf.class);


            PostModel postModel = new PostModel(11, "London");


            Call<PostModel> postModelCall = requestPostsInterf3.putPosts(98, postModel);

            postModelCall.enqueue(new Callback<PostModel>() {
                @Override
                public void onResponse(Call<PostModel> call, Response<PostModel> response) {

                    Toast.makeText(MainActivity.this, "Put Succes", Toast.LENGTH_SHORT).show();

                    PostModel postModel3 = response.body();


                    int userid = postModel3.getUserId();
                    int id = postModel3.getId();
                    String title = postModel3.getTitle();
                    String body = postModel3.getBody();

                    text.append(userid + "\n" + id + "\n" + title + "\n" + body + "\n");


                }

                @Override
                public void onFailure(Call<PostModel> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Put Failure", Toast.LENGTH_SHORT).show();

                }
            });


        }
    });


    Thread thread4 = new Thread(new Runnable() {
        @Override
        public void run() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RequestPostsInterf requestPostsInter4 = retrofit.create(RequestPostsInterf.class);

            PostModel postModel4 = new PostModel(15, "Hello World");


            Call<PostModel> patchPosts = requestPostsInter4.patchPosts(48, postModel4);
            patchPosts.enqueue(new Callback<PostModel>() {
                @Override
                public void onResponse(Call<PostModel> call, Response<PostModel> response) {

                    Toast.makeText(MainActivity.this, "Patch Succes", Toast.LENGTH_SHORT).show();


                    PostModel postModel4 = response.body();

                    int userid = postModel4.getUserId();
                    int id = postModel4.getId();
                    String title = postModel4.getTitle();
                    String body = postModel4.getBody();

                    text.append(userid + "\n" + id + "\n" + title + "\n" + body + "\n");


                }

                @Override
                public void onFailure(Call<PostModel> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Patch Failure", Toast.LENGTH_SHORT).show();

                }
            });

        }


    });

    Thread thread5 = new Thread(new Runnable() {
        @Override
        public void run() {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            RequestPostsInterf requestPostsInterf5 = retrofit.create(RequestPostsInterf.class);


            Call<Void> voidCall = requestPostsInterf5.deletePosts(54);

            voidCall.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {

                    Toast.makeText(MainActivity.this, "Delete Succes", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                    Toast.makeText(MainActivity.this, "Delete Failure", Toast.LENGTH_SHORT).show();

                }
            });


        }
    });


}









