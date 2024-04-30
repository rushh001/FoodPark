package com.example.foodpark;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.foodpark.databinding.FragmentProfileBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Transaction;
import com.squareup.picasso.Picasso;

public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;
    GoogleSignInClient googleSignInClient;
    FirebaseAuth auth;
    FirebaseFirestore firestore=FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentProfileBinding.inflate(inflater,container,false);
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Toast.makeText(getActivity(), "Error1", Toast.LENGTH_SHORT).show();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(getActivity(), gso);
        auth = FirebaseAuth.getInstance();
        //Toast.makeText(getActivity(), "Error2", Toast.LENGTH_SHORT).show();
        binding.signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (auth.getCurrentUser() != null)
                    auth.signOut();
                Intent intent = new Intent(getActivity(), Auth_Vit.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

       // Toast.makeText(getActivity(), "Error3", Toast.LENGTH_SHORT).show();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        String id= user.getUid();
        DocumentReference documentReference=firestore.collection("user").document(id);
       // Toast.makeText(getActivity(), "Error4", Toast.LENGTH_SHORT).show();
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists())
                {//Toast.makeText(getActivity(), "Error5", Toast.LENGTH_SHORT).show();
                    String url=documentSnapshot.getString("userProfile");
                    Picasso.get().load(url).into(binding.profileImage);

                    binding.fullName.setText(documentSnapshot.getString("userName"));
                    // Toast.makeText(getActivity(), "Error2", Toast.LENGTH_SHORT).show();

                    binding.name.setText("@"+documentSnapshot.getString("userName").substring(0,binding.fullName.getText().toString().indexOf(" ")));

                    if (!documentSnapshot.getString("userAge").equals(" "))
                    {
                        binding.age.setText(documentSnapshot.getString("userAge"));}

                    if (!documentSnapshot.getString("userYear").equals(" "))
                    {  // Toast.makeText(getActivity(), "Error1", Toast.LENGTH_SHORT).show();
                        binding.year.setText(documentSnapshot.getString("userYear"));}

                    if (!documentSnapshot.getString("userMess").equals(" "))
                    {  //Toast.makeText(getActivity(), "Error1", Toast.LENGTH_SHORT).show();
                        binding.mess.setText(documentSnapshot.getString("userMess"));}

                    if (!documentSnapshot.getString("userMessType").equals(" "))
                    { //Toast.makeText(getActivity(), "Error1", Toast.LENGTH_SHORT).show();
                        binding.type.setText(documentSnapshot.getString("userMessType"));}

                    if (!documentSnapshot.getString("userHostel").equals(" "))
                    { //Toast.makeText(getActivity(), "Error1", Toast.LENGTH_SHORT).show();
                        binding.block.setText(documentSnapshot.getString("userHostel"));}

                    if (!documentSnapshot.getString("userState").equals(" "))
                    { //Toast.makeText(getActivity(), "Error1", Toast.LENGTH_SHORT).show();
                        binding.state.setText(documentSnapshot.getString("userState"));}


                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
            }
        });







        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_details userDetails=new user_details();
                if(binding.age.getText().toString().isEmpty())
                    Toast.makeText(getActivity(), "Enter Age", Toast.LENGTH_SHORT).show();
                else if(binding.year.getText().toString().isEmpty())
                    Toast.makeText(getActivity(), "Enter Year", Toast.LENGTH_SHORT).show();
                else if(binding.type.getText().toString().isEmpty())
                    Toast.makeText(getActivity(), "Enter Mess Type", Toast.LENGTH_SHORT).show();
                else if(binding.block.getText().toString().isEmpty())
                    Toast.makeText(getActivity(), "Enter Block", Toast.LENGTH_SHORT).show();
                else if(binding.mess.getText().toString().isEmpty())
                    Toast.makeText(getActivity(), "Select Mess", Toast.LENGTH_SHORT).show();
                else if(binding.state.getText().toString().isEmpty())
                    Toast.makeText(getActivity(), "Enter State", Toast.LENGTH_SHORT).show();
                else {
                    firestore.runTransaction(new Transaction.Function<Void>() {
                                @Override
                                public Void apply(@NonNull Transaction transaction) throws FirebaseFirestoreException {
                                    // DocumentSnapshot snapshot = transaction.get(sfDocRef);


                                    transaction.update(documentReference, "userAge", binding.age.getText().toString());
                                    transaction.update(documentReference, "userYear", binding.year.getText().toString());
                                    transaction.update(documentReference, "userMess", binding.mess.getText().toString());
                                    transaction.update(documentReference, "userMessType", binding.type.getText().toString());
                                    transaction.update(documentReference, "userHostel", binding.block.getText().toString());
                                    transaction.update(documentReference, "userState", binding.state.getText().toString());


                                    // Success
                                    return null;
                                }
                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                                }
                            });

                }

            }
        });





    }
}