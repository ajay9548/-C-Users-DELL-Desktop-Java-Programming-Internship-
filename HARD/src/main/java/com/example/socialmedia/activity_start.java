package com.example.socialmedia;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class activity_start extends AppCompatActivity {

	private ImageView iconImage;
	private LinearLayout linearLayout;

	@SuppressLint("MissingInflatedId")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		iconImage = findViewById(R.id.icon_image);
		linearLayout = findViewById(R.id.linear_layout);
		Button register = findViewById(R.id.register);
		Button login = findViewById(R.id.login);

		linearLayout.animate().alpha(0f).setDuration(10);

		TranslateAnimation animation = new TranslateAnimation(0, 0, 0, -1500);
		animation.setDuration(1000);
		animation.setFillAfter(false);
		animation.setAnimationListener(new MyAnimationListener());

		iconImage.setAnimation(animation);

		register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(activity_start.this, RegisterActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
			}
		});

		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(activity_start.this, LoginActivity.class)
						.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
			}
		});
	}

	private class MyAnimationListener implements Animation.AnimationListener {

		@Override
		public void onAnimationStart(Animation animation) {

		}

		@Override
		public void onAnimationEnd(Animation animation) {
			iconImage.clearAnimation();
			iconImage.setVisibility(View.INVISIBLE);
			linearLayout.animate().alpha(1f).setDuration(1000);
		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}
	}
}
