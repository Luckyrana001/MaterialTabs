package info.androidhive.materialtabs.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;

import info.androidhive.materialtabs.R;

public class MenuActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_sliding);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        initLayout();

    }
    private void initLayout() {



    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

               /* Start right to left animation*/
                // overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);

                break;
        }
        return true;
    }

public void onBackPressed()
{
    super.onBackPressed();
    /*Intent i=new Intent(MenuActivity.this,MainActivity.class);
    startActivity(i);*/
    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    //finish();
}

}
