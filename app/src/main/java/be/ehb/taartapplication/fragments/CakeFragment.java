package be.ehb.taartapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import be.ehb.taartapplication.R;
import be.ehb.taartapplication.model.Cake;
import be.ehb.taartapplication.model.CakeModel;

public class CakeFragment extends Fragment {

    private View.OnClickListener mToastListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "aangebrand", Toast.LENGTH_LONG).show();
        }
    };

    private View.OnClickListener mBassListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            BassDialogFragment bdf = new BassDialogFragment();
            bdf.show(getActivity().getSupportFragmentManager(), "bdf");
        }
    };

    public CakeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_cake, container, false);

        Button mToastButton = mView.findViewById(R.id.btn_toast);
        mToastButton.setOnClickListener(mToastListener);

        Button mBassButton = mView.findViewById(R.id.btn_bass);
        mBassButton.setOnClickListener(mBassListener);

        TextView cakeDescription = mView.findViewById(R.id.tv_cake_description);
        CakeModel mCakeModel = new ViewModelProvider(getActivity()).get(CakeModel.class);
        mCakeModel.getmCake().observe(getActivity(), new Observer<Cake>() {
            @Override
            public void onChanged(Cake cake) {
                cakeDescription.setText(cake.getBass());
            }
        });


        return mView;
    }
}
