package com.shangshaban.zhaopin.activity2.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * songzhengpeng
 * 2018/3/24
 */
public class OGLUtils {
    public final static String SOURCE_DEFAULT_NAME_FRAGMENT = "fragment.glsl";
    public final static String SOURCE_DEFAULT_NAME_VERTEX = "vertex.glsl";

    public OGLUtils() {
    }

    public static int getProgram(Context context) {
        String vertexStr = getShaderSource(context, SOURCE_DEFAULT_NAME_VERTEX);
        String fragmentStr = getShaderSource(context, SOURCE_DEFAULT_NAME_FRAGMENT);
        return getProgram(vertexStr, fragmentStr);
    }

    public static int getProgram(String vertexStr, String fragmentStr) {
        int program = GLES20.glCreateProgram();
        int fragmentShader = GLES20.glCreateShader(35632);
        int vertexShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(vertexShader, vertexStr);
        GLES20.glShaderSource(fragmentShader, fragmentStr);
        GLES20.glCompileShader(vertexShader);
        GLES20.glCompileShader(fragmentShader);
        GLES20.glAttachShader(program, vertexShader);
        GLES20.glAttachShader(program, fragmentShader);
        GLES20.glLinkProgram(program);
        return program;
    }

    public static String getShaderSource(Context context, String sourseName) {
        StringBuffer shaderSource = new StringBuffer();
        BufferedReader br = null;

        try {
             br = new BufferedReader(new InputStreamReader(context.getAssets().open(sourseName),"utf-8"));
            String tempStr = null;

            while(null != (tempStr = br.readLine())) {
                shaderSource.append(tempStr);
            }
        } catch (IOException var5) {
            var5.printStackTrace();
        }finally {
            try {
                if (br !=null){

                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return shaderSource.toString();
    }

    protected static int bindTexture(Context context, int drawable) {
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inScaled = false;
        return bindTexture(BitmapFactory.decodeResource(context.getResources(), drawable, option));
    }

    protected static int bindTexture(Bitmap bitmap) {
        int[] textures = new int[1];
        GLES20.glGenTextures(1, textures, 0);
        GLES20.glBindTexture(3553, textures[0]);
        GLES20.glTexParameteri(3553, 10242, 10497);
        GLES20.glTexParameteri(3553, 10243, 10497);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9987);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glGenerateMipmap(3553);
        GLES20.glBindTexture(3553, 0);
        return textures[0];
    }

    public static void checkGlError(String op) {
        int error;
        if ((error = GLES20.glGetError()) != 0) {
            Log.e("ES20_ERROR", op + ": glError " + error);
            throw new RuntimeException(op + ": glError " + error);
        }
    }

    public static int initTexture(Context context, int drawableId) {
        int[] textures = new int[1];
        GLES20.glGenTextures(1, textures, 0);
        int textureId = textures[0];
        GLES20.glBindTexture(3553, textureId);
        GLES20.glTexParameterf(3553, 10241, 9728.0F);
        GLES20.glTexParameterf(3553, 10240, 9729.0F);
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
        InputStream is = context.getResources().openRawResource(drawableId);

        Bitmap bitmapTmp;
        try {
            bitmapTmp = BitmapFactory.decodeStream(is);
        } finally {
            try {
                is.close();
            } catch (IOException var12) {
                var12.printStackTrace();
            }

        }

        GLUtils.texImage2D(3553, 0, bitmapTmp, 0);
        bitmapTmp.recycle();
        return textureId;
    }
}

