package be.ehb.taartapplication.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class CakeModel extends AndroidViewModel {

    MutableLiveData<Cake> mCake;

    public CakeModel(@NonNull Application application) {
        super(application);
        mCake = new MutableLiveData<Cake>();
        mCake.setValue(new Cake());
    }

    public MutableLiveData<Cake> getmCake() {
        return mCake;
    }

    public void setCakeBass(String bass){
        Cake temp = mCake.getValue();
        temp.setBass(bass);
        mCake.setValue(temp);
    }
}
