package com.xuge.sampletest.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.xuge.sampletest.R;

import java.io.ByteArrayOutputStream;

public class BitmapTestActivity extends AppCompatActivity {

    private static final String TAG = BitmapTestActivity.class.getSimpleName();

    private AppCompatImageView imageView;
    private Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_test);
        imageView = findViewById(R.id.image);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.routine_bg_morning);

        imageView.setImageBitmap(bitmap);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        Log.d(TAG, this.hashCode() + "   onCreate: densityDpi = " + displayMetrics.densityDpi);
        Log.d(TAG, this.hashCode() + "   onCreate: density = " + displayMetrics.density);

    }

    public void calculateBitmapMemory(View view) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_facebook, options);

        Log.i(TAG, "bitmap：ByteCount = " + bitmap.getByteCount() + ":::bitmap：AllocationByteCount = " + bitmap.getAllocationByteCount());
        Log.i(TAG, "width:" + bitmap.getWidth() + ":::height:" + bitmap.getHeight());
        Log.i(TAG, "inDensity:" + options.inDensity + ":::inTargetDensity:" + options.inTargetDensity);

        Log.i(TAG, "===========================================================================");

        // 手动设置inDensity与inTargetDensity，影响缩放比例。
        BitmapFactory.Options options_setParams = new BitmapFactory.Options();
        options_setParams.inDensity = 320;
        options_setParams.inTargetDensity = 320;
        Bitmap bitmap_setParams = BitmapFactory.decodeResource(getResources(), R.drawable.ic_facebook, options_setParams);
        Log.i(TAG, "bitmap_setParams：ByteCount = " + bitmap_setParams.getByteCount() + ":::bitmap_setParams：AllocationByteCount = " + bitmap_setParams.getAllocationByteCount());
        Log.i(TAG, "width:" + bitmap_setParams.getWidth() + ":::height:" + bitmap_setParams.getHeight());
        Log.i(TAG, "inDensity:" + options_setParams.inDensity + ":::inTargetDensity:" + options_setParams.inTargetDensity);
    }


    public void compressImage(View view) {
        imageView.setImageBitmap(compressImage(bitmap, 5000));
    }

    public void compressBySampleSize(View view) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 4;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.routine_bg_morning, options);
        imageView.setImageBitmap(bitmap);

        Log.i(TAG, "compressBySampleSize --> bitmap：ByteCount = " + bitmap.getByteCount() + ":::bitmap：AllocationByteCount = " + bitmap.getAllocationByteCount());
        Log.i(TAG, "compressBySampleSize --> width:" + bitmap.getWidth() + ":::height:" + bitmap.getHeight());
        Log.i(TAG, "compressBySampleSize --> inDensity:" + options.inDensity + ":::inTargetDensity:" + options.inTargetDensity);
    }

    /**
     * 质量压缩
     *
     * @param image   - 目标原图
     * @param maxSize - 最大的图片大小
     * @return
     */
    private Bitmap compressImage(Bitmap image, long maxSize) {
        int byteCount = image.getByteCount();
        Log.d(TAG, this.hashCode() + "   compressImage: before = " + byteCount);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 把ByteArrayInputStream数据生成图片
        Bitmap bitmap = null;
        image.compress(Bitmap.CompressFormat.JPEG, 100, baos);

        int options = 90;

        // 循环判断如果压缩后图片是否大于maxSize,大于继续压缩
        while (baos.toByteArray().length > maxSize) {
            // 重置baos即清空baos
            baos.reset();
            // 这里压缩options%，把压缩后的数据存放到baos中
            image.compress(Bitmap.CompressFormat.JPEG, options, baos);
            // 每次都减少10，当为1的时候停止，options<10的时候，递减1
            if (options == 1) {
                break;
            } else if (options <= 10) {
                options -= 1;
            } else {
                options -= 10;
            }
        }

        byte[] bytes = baos.toByteArray();

        if (bytes.length != 0) {
            // 把压缩后的数据baos存放到bytes中
            bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            int byteCount1 = bitmap.getByteCount();
            Log.d(TAG, this.hashCode() + "   compressImage: after = " + byteCount1);
        }

        return bitmap;
    }

}
