package sblib.bobsun.sblib.activities;
;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bobsun on 15-7-6.
 */
public class BaseActivity extends AppCompatActivity {

    public FragmentManager mFragmentManager;
    public Fragment mCurrentFragment;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
    }

    public void addFragments(Fragment[] fragments, int fragmentContainer){
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        for(Fragment fragment : fragments){
            transaction.add(fragmentContainer,fragment,fragment.hashCode()+"");
        }
        transaction.commit();
    }

    public void switchFragmentTo(Fragment fragment, int fragmentContainer){
        if (mFragmentManager.findFragmentByTag(fragment.getClass().getName()) == null)
            mFragmentManager.beginTransaction().add(fragmentContainer,fragment,fragment.hashCode()+"").commit();
        if (mCurrentFragment == null){
            mFragmentManager.beginTransaction().show(fragment).commit();
        } else {
            mFragmentManager.beginTransaction().hide(mCurrentFragment).show(fragment).commit();
        }
        mCurrentFragment = fragment;
    }
}
