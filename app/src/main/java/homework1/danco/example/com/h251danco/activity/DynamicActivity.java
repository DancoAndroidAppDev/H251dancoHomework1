package homework1.danco.example.com.h251danco.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;

import homework1.danco.example.com.h251danco.DummyContent;
import homework1.danco.example.com.h251danco.R;
import homework1.danco.example.com.h251danco.fragment.DynamicFragment;

public class DynamicActivity extends ActionBarActivity
        implements DynamicFragment.DynamicFragmentListener {

    private static final String FRAGMENT_TAG = "ContactDetails";
    private static DummyContent.DummyItem ITEM;

    public static Intent buildIntent(Context context, DummyContent.DummyItem item) {
        Intent intent = new Intent(context, DynamicActivity.class);
        // item clicked information handled here
        ITEM = item;
        intent.putExtra(item.id, item);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        if (savedInstanceState == null) {
            DynamicFragment fragment = DynamicFragment.newInstance(ITEM);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.dynamicFragmentContainer, fragment, FRAGMENT_TAG)
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dynamic, menu);
        return true;
    }


    @Override
    public void onDatePickerOk() {
        // Alternately you could call finish() but that could cause problems.
        // This is coming in a future class
        NavUtils.navigateUpFromSameTask(this);
    }
}
