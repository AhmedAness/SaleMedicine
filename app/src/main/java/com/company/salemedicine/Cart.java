package com.company.salemedicine;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.company.salemedicine.Adapter.MedicineAdapter;
import com.company.salemedicine.model.MedicineModel;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.Inflater;

public class Cart extends Fragment {

    DecoratedBarcodeView dbvScanner;
    MedicineAdapter adapter;
    RecyclerView rv;
    List<MedicineModel> medicineModelList = new ArrayList<>();
    private String lastText;

    private OnFragmentInteractionListener mListener;

    public Cart() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void beepSound() {
        try {
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getContext(), notification);
            r.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void resumeScanner() {
        if (!dbvScanner.isActivated()) {
            dbvScanner.resume();
        }
        Log.d("peeyush-pause", "paused: false");
    }

    protected void pauseScanner() {
        dbvScanner.pause();
    }



    void requestPermission() {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, 0);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0 && grantResults.length < 1) {
            requestPermission();
        } else {
            dbvScanner.resume();
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        resumeScanner();
    }
    @Override
    public void onPause() {
        super.onPause();
        pauseScanner();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View inflater1=inflater.inflate(R.layout.fragment_cart, container, false);

        dbvScanner = inflater1.findViewById(R.id.BarcodeScan);
        rv = inflater1.findViewById(R.id.ItemsRecycler);

        requestPermission();

        dbvScanner.decodeContinuous(new BarcodeCallback() {
            @Override
            public void barcodeResult(BarcodeResult result) {
                if(result.getText() == null || result.getText().equals(lastText)) {
                    // Prevent duplicate scans
                    return;
                }
                lastText = result.getText();
                Toast.makeText(getContext(), result.getText(), Toast.LENGTH_SHORT).show();
                beepSound();
                medicineModelList.add(new MedicineModel(1,result.getText(),3,3));
                adapter = new MedicineAdapter(medicineModelList);
                rv.setAdapter(adapter);
            }

            @Override
            public void possibleResultPoints(List<ResultPoint> resultPoints) {

            }
        });


//        adapter = new MedicineAdapter(medicineModelList);
//        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);


        return inflater1;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
