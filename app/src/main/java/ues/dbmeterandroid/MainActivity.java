package ues.dbmeterandroid;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#E13535")));
        bar.setTitle("Inicio");

        Resources res = getResources();

        TabHost tabs  = (TabHost) findViewById(R.id.tabHost);
        tabs.setup();

        TabHost.TabSpec spec1 = tabs.newTabSpec("tab1");
        spec1.setContent(R.id.Logeados);
        spec1.setIndicator("Reporte LogIn", null);
        tabs.addTab(spec1);


        TabHost.TabSpec spec2 = tabs.newTabSpec("tab2");
        spec2.setContent(R.id.Reportes);
        spec2.setIndicator("Reporte DB", null);
        tabs.addTab(spec2);

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
}
