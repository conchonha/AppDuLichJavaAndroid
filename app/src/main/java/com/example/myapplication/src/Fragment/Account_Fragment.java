package com.example.myapplication.src.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.models.user_reponse.User;
import com.example.myapplication.src.dialog.LoadingDialog_new;
import com.example.myapplication.src.Activity.HelpsSuport;
import com.example.myapplication.src.Activity.LoginActivity;
import com.example.myapplication.src.Activity.MainActivity;
import com.example.myapplication.src.Activity.Myprofile;
import com.example.myapplication.util.ShaPrefs;
import com.example.myapplication.util.constants.Constants;
import com.google.gson.Gson;

public class Account_Fragment extends Fragment {
    private View mView;
    private RelativeLayout relativeAcountMyprofile,relivelayouhelps_supporrt,relivelayoutabout,relivelayoutlogout;
    private TextView txttenuser;
    private ShaPrefs mShaPrefs;
    private User mUser;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView =inflater.inflate(R.layout.account_fragment,container,false);
        init();
        listenerOnclicked();
        return  mView;
    }

    private void listenerOnclicked() {
        relativeAcountMyprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mView.getContext(), Myprofile.class));
                getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_ride);
            }
        });
        relivelayouhelps_supporrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_ride);
                startActivity(new Intent(getActivity(), HelpsSuport.class));
            }
        });
        relivelayoutabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDialog_new.showDialogAcount(getActivity(),"About", Constants.mAbout);
            }
        });
        relivelayoutlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShaPrefs.clear();
                startActivity(new Intent(getContext(),LoginActivity.class));
                getActivity().overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_ride);
                getActivity().finish();
            }
        });
    }

    private void init() {
        mShaPrefs = ShaPrefs.getInstance(getContext());
        txttenuser = mView.findViewById(R.id.txttenuser);
        mUser = new Gson().fromJson(mShaPrefs.getUser(),User.class);
        txttenuser.setText(mUser.getName());

        relivelayoutlogout = mView.findViewById(R.id.relivelayoutlogout);
        relivelayoutabout = mView.findViewById(R.id.relivelayoutabout);
        relivelayouhelps_supporrt = mView.findViewById(R.id.relivelayouhelps_supporrt);
        relativeAcountMyprofile = mView.findViewById(R.id.relativeAcountMyprofile);
    }
}
