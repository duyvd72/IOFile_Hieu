package com.example.qlcv_externalfile;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static <T> List<T> doc(Context context, String filename) {
        List<T> list = new ArrayList<>();
        File f = new File(context.getExternalFilesDir("file"), filename);
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            //Internal file thi xoa dong File.. va dung dong` nay
            //ObjectInputStream ois = new ObjectInputStream(context.openFileInput(filename));
            //
            list = (List<T>) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static <T> void ghi(Context context, String filename, List<T> list) {
        File f = new File(context.getExternalFilesDir("file"), filename);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            //Internal file thi xoa dong File.. va dung dong` nay
            //ObjectOutputStream oos = new ObjectOutputStream(context.openFileOutput(filename, Context.MODE_PRIVATE));
            //
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
