package com.example.android.camera2basic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;

public class ImageShow extends Activity{
    ImageView imageView;
    File imgFile;
    String pathName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_display);
        imageView=(ImageView)findViewById(R.id.imageView);
        Bundle bundle = getIntent().getExtras();
         pathName = bundle.getString("path");
        Toast.makeText(this,""+pathName,Toast.LENGTH_LONG).show();
        imgFile = new  File(pathName);
        if(imgFile.exists()){
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(myBitmap);
        }
   }
    public void save(View view)
    {
        Toast.makeText(this,"File Save Succesfully",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,CameraActivity.class);
        startActivity(intent);
    }
    public void delete(View view)
    {
        File file = new File(pathName);
        boolean deleted = file.delete();
        Toast.makeText(this,"delete ="+deleted,Toast.LENGTH_LONG).show();
        Intent intent=new Intent(this,CameraActivity.class);
        startActivity(intent);
    }
 }
