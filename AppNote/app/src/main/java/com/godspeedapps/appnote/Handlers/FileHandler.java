package com.godspeedapps.appnote.Handlers;

import android.content.Context;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by Christine on 29/3/2018.
 */

public class FileHandler {

    private static File mDir;

    public FileHandler(Context context)
    {
        mDir = context.getFilesDir();
        if (!mDir.exists())
            mDir.mkdir();
    }

    public void createFile(String Name, String Description)
    {
        // Todo - if errors occurs check here
        final File file = new File(mDir,Name);
        FileOutputStream fos ;
        try
        {

            if (!file.exists())
                file.createNewFile();

            fos = new FileOutputStream(file);
            fos.write(Description.getBytes());
            fos.close();
            fos.flush();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public  File[] getFiles()
    {
        //String[] fileNames = mDir.list();
        File[] fileList = mDir.listFiles();
        return fileList;
    }

    public static String[] getFileNames()
    {
        String[] fileList = mDir.list();
        return fileList;
    }

    public String[] getFileContents()
    {
        File[] dirFiles = mDir.listFiles();
        String[] contents = new String[dirFiles.length];

        for ( int i = 0; i < dirFiles.length; i++)
        {
            File file = dirFiles[i];
            byte[] data = new byte[225];
            try (FileInputStream fis = new FileInputStream(file))
            {
                fis.read(data);
                contents[i] = new String(data);
                fis.close();
            } catch ( IOException e) {}
        }

        return contents;
    }

    public void check(Context context)
    {
        long num = mDir.length();
        Toast.makeText(context,"num = " + num,Toast.LENGTH_SHORT).show();
    }
}
