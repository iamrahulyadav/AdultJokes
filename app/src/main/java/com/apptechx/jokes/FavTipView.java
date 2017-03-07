package com.apptechx.jokes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class FavTipView extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.favtipview);

		String _value=getIntent().getExtras().getString("Joke");
		TextView _tv=(TextView) findViewById(R.id.tvTip);
		_tv.setText(_value);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater _inflater = getMenuInflater();
		_inflater.inflate(R.menu.favtipmenu, menu);
		return super.onCreateOptionsMenu(menu);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if(item.getItemId() == R.id.favtipmenuSendbySMS){
			Intent _intent = new Intent(Intent.ACTION_VIEW);
			_intent.putExtra("sms_body", ((TextView) findViewById(R.id.tvTip)).getText());
			_intent.setType("vnd.android-dir/mms-sms");
			startActivity(_intent);
		}
		else if(item.getItemId()==R.id.favtipmenuShare){
			Intent _intent=new Intent(Intent.ACTION_SEND);
			
			_intent.putExtra(Intent.EXTRA_TEXT, ((TextView) findViewById(R.id.tvTip)).getText());
			_intent.setType("text/plain");
			startActivity(_intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
