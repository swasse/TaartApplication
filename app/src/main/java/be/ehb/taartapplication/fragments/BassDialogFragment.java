package be.ehb.taartapplication.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import be.ehb.taartapplication.R;
import be.ehb.taartapplication.model.CakeModel;

public class BassDialogFragment extends DialogFragment {

    FragmentActivity activity;
    private int indexBass = 0;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (FragmentActivity) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);

        mBuilder.setTitle(R.string.str_title_dialog_bass);
        mBuilder.setSingleChoiceItems(R.array.cake_basses, indexBass, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String bass = getResources().getStringArray(R.array.cake_basses)[i];
                indexBass = i;
            }
        });

        mBuilder.setNegativeButton(R.string.str_btn_cancel, (DialogInterface dialogInterface, int i)->{
            //code als ik cancel
        });
        mBuilder.setPositiveButton(R.string.str_btn_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String[] basses = getResources().getStringArray(R.array.cake_basses);
                CakeModel mCakeModel = new ViewModelProvider(activity).get(CakeModel.class);
                mCakeModel.setCakeBass(basses[indexBass]);
            }
        });

        return mBuilder.create();
    }
}
