package com.sourab.videorecorder.util;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorInt;
import android.util.Log;
import android.util.TypedValue;


import com.sourab.videorecorder.interfaces.Interfaces;

import java.util.Random;


public final class CustomUtil {

    private CustomUtil() {}

    public static int rotateVideo(Context paramContext, String currentVideo, String mOutput, boolean frontCamera, boolean isRotateVideo) {
        return (new Processor(getEncodingLibraryPath(paramContext), paramContext)).newCommand().addInputPath(currentVideo).setRotateFilter(frontCamera, isRotateVideo).setAudioCopy().setThread().setPreset().setStrict().enableOverwrite().processToOutput(mOutput);
    }

    public static int transponseVideo(Context paramContext, String currentVideo, String mOutput, boolean frontCamera, boolean isRotateVideo) {
        return (new Processor(getEncodingLibraryPath(paramContext), paramContext)).newCommand().addInputPath(currentVideo).setTransposeFilter(frontCamera, isRotateVideo).setAudioCopy().setThread().setPreset().setStrict().enableOverwrite().processToOutput(mOutput);
    }

    public static String getEncodingLibraryPath(Context paramContext) {
        return paramContext.getApplicationInfo().nativeLibraryDir + "/libencoding.so";
    }

    public static void addBitmapOverlayOnVideo(Context context, String videoPath, String bitmapPath, String outputPath) {
        (new Processor(getEncodingLibraryPath(context), context)).newCommand().enableOverwrite().addInputPath(videoPath).setWaterMark(bitmapPath).setThread().setPreset().setStrict().processToOutput(outputPath);
    }

    @ColorInt
    public static int getThemeColorAttribute(Resources.Theme theme, @AttrRes int attribute) {
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(attribute, typedValue, true);
        return typedValue.data;
    }
}


