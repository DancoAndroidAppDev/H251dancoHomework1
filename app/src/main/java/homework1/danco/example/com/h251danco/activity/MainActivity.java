package homework1.danco.example.com.h251danco.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import homework1.danco.example.com.h251danco.R;
import homework1.danco.example.com.h251danco.DummyContent;
import homework1.danco.example.com.h251danco.fragment.ItemListFragment;


public class MainActivity extends ActionBarActivity
        implements ItemListFragment.ItemFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.app_name);

        if (savedInstanceState == null) {
            ItemListFragment fragment = (ItemListFragment)
                    getSupportFragmentManager().findFragmentById(R.id.main_fragment);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onUpdateDynamicFragment(DummyContent.DummyItem item) {
        startActivity(DynamicActivity.buildIntent(this, item));
    }
}
