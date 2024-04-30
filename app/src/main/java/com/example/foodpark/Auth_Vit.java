package com.example.foodpark;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.units.qual.A;

public class Auth_Vit extends AppCompatActivity {

    Button button;
    FirebaseAuth auth;
    FirebaseFirestore database;
    GoogleSignInClient googleSignInClient;
    ProgressBar progressBar;
    int RC_SIGN_IN = 20;
   public String s="no";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_vit);

        auth = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        button = findViewById(R.id.SignUpbtn);
        progressBar= findViewById(R.id.progressBar2);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this, gso);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(SignUp.this,"phase a",Toast.LENGTH_SHORT).show();
                googleSignIn();
                progressBar.setVisibility(View.VISIBLE);

            }

        });



        if(auth.getCurrentUser()!=null){
            // Toast.makeText(SignUp.this,"phase 2",Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(Auth_Vit.this,Navigation_bar.class);
            startActivity(intent);
            finish();
        }


    }

    private void googleSignIn() {
        Intent intent=googleSignInClient.getSignInIntent();
        startActivityForResult(intent,RC_SIGN_IN);
        // Toast.makeText(SignUp.this,"phase1",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==RC_SIGN_IN)
        {          //progressBar.setVisibility(View.VISIBLE);
            Task<GoogleSignInAccount> task= GoogleSignIn.getSignedInAccountFromIntent(data);
            try{

                GoogleSignInAccount account= task.getResult(ApiException.class);
                //Toast.makeText(SignUp.this,"phase2",Toast.LENGTH_SHORT).show();
               // FirebaseUser user = auth.getCurrentUser();
               // user_details userDetails=new user_details();
                //String email=user.getEmail().toString();

                        firebaseAuth(account.getIdToken());



            }

            catch (ApiException e)
            {
                Toast.makeText(Auth_Vit.this,e.toString(),Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void firebaseAuth(String idToken) {
        //Toast.makeText(SignUp.this,idToken,Toast.LENGTH_SHORT).show();
        AuthCredential credential= GoogleAuthProvider.getCredential(idToken,null);
        auth.signInWithCredential(credential).addOnCompleteListener(Auth_Vit.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    // Toast.makeText(SignUp.this,"phase3",Toast.LENGTH_SHORT).show();
                    FirebaseUser user = auth.getCurrentUser();
                    user_details userDetails=new user_details();
                    userDetails.setUserId(user.getUid());
                    userDetails.setUserName(user.getDisplayName());
                    userDetails.setUserProfile(user.getPhotoUrl().toString());
                    userDetails.setUserEmail(user.getEmail().toString());
                    String email=user.getEmail().toString();





                    userDetails.setUserAge(" ");
                    userDetails.setUserYear(" ");
                    userDetails.setUserMess(" ");
                    userDetails.setUserMessType(" ");
                    userDetails.setUserHostel(" ");
                    userDetails.setUserState(" ");



                    String id=user.getUid();

                    // Toast.makeText(SignUp.this,"phase4",Toast.LENGTH_SHORT).show();
                    database.collection("user").document(id).set(userDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            //Toast.makeText(SignUp.this,"phase5",Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.INVISIBLE);
                            if(task.isSuccessful())
                            {  Intent intent = new Intent(Auth_Vit.this, Navigation_bar.class);
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(Auth_Vit.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

                else {
                    Toast.makeText(Auth_Vit.this,"failed",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }



}