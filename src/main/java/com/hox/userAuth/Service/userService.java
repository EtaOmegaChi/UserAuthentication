package com.hox.userAuth.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.Gson;
import com.hox.userAuth.bean.userBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class userService {
    @Autowired
    private Gson gson;

    public String createUser(userBean ub) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> CollectionApiFuture = dbFirestore.collection("hoxUser").document(ub.getDocumentID()).set(ub);
        return CollectionApiFuture.get().getUpdateTime().toString();
    }

    public userBean getUser(String documentID) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("hoxUser").document(documentID);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();

        //check for whether we can retrieve the data from documentID, if not then we should return null.
        if(document.exists()){
            userBean newU = document.toObject(userBean.class);
            return newU;
        }
        return null;
    }

    public String updateUser(userBean ub) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("hoxUser").document(ub.getDocumentID()).set(ub);
        return writeResult.get().getUpdateTime().toString();
    }

    public String deteleUser(String documentID){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("hoxUser").document(documentID).delete();
        return "Successfully deleted" + documentID;
    }

    public ResponseEntity<String> logIn(String username, String password){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> signUp(String username, String email, String password){
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
