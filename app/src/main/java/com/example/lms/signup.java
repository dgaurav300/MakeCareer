    package com.example.lms;

    import static com.example.lms.R.id.signup1;

    import androidx.appcompat.app.AppCompatActivity;

    import android.annotation.SuppressLint;
    import android.content.Intent;
    import android.os.AsyncTask;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ProgressBar;
    import android.widget.Toast;

    import com.example.lms.API_URLS.RetrofitAPI;
    import com.example.lms.API_URLS.URLS;
    import com.example.lms.Models.User;
    import com.example.lms.Request.RequestHandler;
    import com.example.lms.SharedPreference.SharedPrefManager;
    import com.example.lms.respones.RegisterResponse;

    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.HashMap;

    import retrofit2.Call;
    import retrofit2.Callback;
    import retrofit2.Response;
    import retrofit2.Retrofit;
    import retrofit2.converter.gson.GsonConverterFactory;


    public class signup extends AppCompatActivity {
    Button btnLogin,btnSignUp;
    ProgressBar progressBar;
    EditText editTextFullName,editTextEmail,editTextContact,editTextPassword;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            //if the user is already logged in we will directly start the profile activity
            if (SharedPrefManager.getInstance(this).isLoggedIn()) {
                finish();
                startActivity(new Intent(this, DashBoardActivity.class));
                return;
            }

            btnLogin = findViewById(R.id.btnLogin);
            btnSignUp=findViewById(R.id.btnSignUp);

            editTextFullName=findViewById(R.id.editTextFullName);
            editTextEmail=findViewById(R.id.editTextEmail);
            editTextContact=findViewById(R.id.editTextContact);
            editTextPassword=findViewById(R.id.editTextPassword);

            progressBar=findViewById(R.id.progressBar);



            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //if user pressed on button register
                    //here we will register the user to server
                    registerUser();
                }
            });

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //if user pressed on login
                    //we will open the login screen
                    finish();
                    startActivity(new Intent(signup.this, MainActivity.class));
                }
            });


        }

        private void registerUser() {

            final String full_name = editTextFullName.getText().toString().trim();
            final String email = editTextEmail.getText().toString().trim();
            final String contact_number = editTextContact.getText().toString();
            final String password = editTextPassword.getText().toString().trim();

            //first we will do the validations
            if (full_name.isEmpty()) {
                editTextFullName.setError("Please enter Full Name");
                editTextFullName.requestFocus();
                return;
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editTextEmail.setError("Enter a valid email");
                editTextEmail.requestFocus();
                return;
            }
            if (contact_number.isEmpty()) {
                editTextContact.setError("Enter Contact Number");
                editTextContact.requestFocus();
                return;
            }
            if (password.isEmpty()) {
                editTextPassword.setError("Enter a Password");
                editTextPassword.requestFocus();
                return;
            }
            //if it passes all the validations
            progressBar.setVisibility(View.VISIBLE);


// Execute the AsyncTask to handle registration
            new RegisterUserAsyncTask().execute(full_name, email, contact_number, password);


           }
        private class RegisterUserAsyncTask extends AsyncTask<String,Void,Boolean>{

            @Override
            protected Boolean doInBackground(String... params) {
                String full_name = params[0];
                String email = params[1];
                String contact_number = params[2];
                String password = params[3];


                // Initialize Retrofit
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(URLS.ROOT_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                 // Create the RetrofitAPI instance
                RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

                // Make the API call
                Call<RegisterResponse> call = retrofitAPI.register(full_name, email, contact_number, password);
                try {
                    Response<RegisterResponse> response = call.execute();

                    if (response.isSuccessful()) {
                        // Registration was successful
                        return true;
                    } else {
                        // Registration failed
                        return false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // Network error occurred
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean registrationSuccessful) {
                // Hide the ProgressBar after the AsyncTask is complete
                progressBar.setVisibility(View.INVISIBLE);

                // Handle the registration result
                if (registrationSuccessful) {
                    // Registration was successful
                    Toast.makeText(signup.this, "Registration successful", Toast.LENGTH_SHORT).show();
                } else {
                    // Registration failed
                    Toast.makeText(signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }



            }
    }



