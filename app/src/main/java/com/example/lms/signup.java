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

    import com.example.lms.API_URLS.URLS;
    import com.example.lms.Models.User;
    import com.example.lms.Request.RequestHandler;
    import com.example.lms.SharedPreference.SharedPrefManager;

    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.HashMap;


    public class signup extends AppCompatActivity {
    Button btnLogin,btnSignUp;
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
            class RegisterUser extends AsyncTask<Void, Void, String> {
                private ProgressBar progressBar;

                @Override
                protected String doInBackground(Void... voids) {
                    //creating request handler object
                    RequestHandler requestHandler = new RequestHandler();
                    //creating request parameters
                    HashMap<String, String> params = new HashMap<>();
                    params.put("full_name", full_name);
                    params.put("email", email);
                    params.put("contact_number", contact_number);
                    params.put("password", password);

                    //returing the response
                    return requestHandler.sendPostRequest(URLS.URL_REGISTER, params);
                }

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    //displaying the progress bar while user registers on the server
                    progressBar = (ProgressBar) findViewById(R.id.progressBar);
                    progressBar.setVisibility(View.VISIBLE);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    //hiding the progressbar after completion
                    progressBar.setVisibility(View.GONE);
                    try {
                        //converting response to json object
                        JSONObject obj = new JSONObject(s);
                        //if no error in response
                        if (!obj.getBoolean("error")) {
                            Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            //getting the user from the response
                            JSONObject userJson = obj.getJSONObject("user");
                            //creating a new user object
                            User user = new User(
                                    userJson.getInt("id"),
                                    userJson.getString("full_name"),
                                    userJson.getString("email"),
                                    userJson.getString("contact_number")
                            );
                            //storing the user in shared preferences
                            SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);                        //starting the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            //executing the async task
            RegisterUser ru = new RegisterUser();
            ru.execute();


        }
    }
