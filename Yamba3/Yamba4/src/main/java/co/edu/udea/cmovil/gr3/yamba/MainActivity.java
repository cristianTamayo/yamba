package co.edu.udea.cmovil.gr3.yamba;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { //
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class)); //
                return true; //
            case R.id.action_tweet:
                startActivity(new Intent("co.edu.udea.cmovil.gr3.yamba.action.tweet"));
                return true;
            case R.id.action_refresh:
                startService(new Intent(this,RefreshService.class));
                return true;
            default:
                return false;
        }
    }
}
