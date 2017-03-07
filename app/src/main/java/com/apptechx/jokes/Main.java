package com.apptechx.jokes;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.mqnvnfx.itwsdvr70223.AdListener;
import com.mqnvnfx.itwsdvr70223.AdView;



public class Main extends Activity implements OnClickListener {



    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        // Create Database
        DBHelper _helper = new DBHelper(this);
        SQLiteDatabase _db = _helper.getWritableDatabase();
        _helper.InitiateDatabase(_db);
        _helper.close();

        //Open TipView page
        Button _btn = (Button) findViewById(R.id.btnStart);
        _btn.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(Main.this, TipviewActivity.class));
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

//		if(keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0)
//		{
//			try {
//				Airpush _ap = new Airpush(getApplicationContext());
//				_ap.startSmartWallAd();
//			} catch (Exception e) {/* Suppress Airpush errors*/}
//		}
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub

        MenuInflater _menu = getMenuInflater();
        _menu.inflate(R.menu.mainviewmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub

        if (item.getItemId() == R.id.mainListFav) {
            startActivity(new Intent(Main.this, FavList.class));
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

    }

    @Override
    public void onBackPressed() {


            super.onBackPressed();

    }
    // -------- AD -------
}
