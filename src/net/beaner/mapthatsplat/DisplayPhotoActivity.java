package net.beaner.mapthatsplat;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DisplayPhotoActivity extends Activity implements View.OnClickListener
{
	Intent i;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showphoto);

		i = getIntent();

		final ImageView iv = (ImageView)findViewById(R.id.photo);
		final WindowManager wm = getWindowManager();
		final int device_height = wm.getDefaultDisplay().getHeight();
		final int device_width = wm.getDefaultDisplay().getWidth();
		int height;
		if(device_height > device_width) {
			height = device_height / 10 * 4;
		} else {
			height = device_height / 10 * 8;
		}
		int width = device_width;
		iv.setLayoutParams(new LinearLayout.LayoutParams(width, height));
		iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		iv.startAnimation(AnimationUtils.loadAnimation(this, R.anim.spinner));

		final TextView text = (TextView)findViewById(R.id.photo_text);
		text.setText(i.getStringExtra("caption"));

		final String url = i.getStringExtra("url");
		ImageDownloader.get(url, iv);
	} // onCreate

	@Override
	public boolean onTouchEvent(final MotionEvent event)
	{
		if(event.getAction() == MotionEvent.ACTION_UP)
			finish();
		return false;
	} // onTouchEvent

	@Override
	public void onClick(View v)
	{
	} // onClick
} // DisplayPhotoActivity
