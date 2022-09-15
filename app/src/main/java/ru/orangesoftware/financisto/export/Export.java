package ru.orangesoftware.financisto.export;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Environment;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.GZIPOutputStream;

import ru.orangesoftware.financisto.export.drive.GoogleDriveClientV3;
import ru.orangesoftware.financisto.export.drive.GoogleDriveClientV3_;
import ru.orangesoftware.financisto.export.dropbox.Dropbox;
import ru.orangesoftware.financisto.utils.MyPreferences;

public abstract class Export {

    public static final String BACKUP_MIME_TYPE = "application/x-gzip";

    private final Context context;
    private final boolean useGzip;

    protected Export(Context context, boolean useGzip) {
        this.context = context;
        this.useGzip = useGzip;
    }

    public String export() throws Exception {
        File path = getBackupFolder(context);
        String fileName = generateFilename();
        File file = new File(path, fileName);
        FileOutputStream outputStream = new FileOutputStream(file);
        try {
            if (useGzip) {
                export(new GZIPOutputStream(outputStream));
            } else {
                export(outputStream);
            }
        } finally {
            outputStream.flush();
            outputStream.close();
        }
        return fileName;
    }

    protected void export(OutputStream outputStream) throws Exception {
        generateBackup(outputStream);
    }

    public String generateFilename() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd'_'HHmmss'_'SSS");
        return df.format(new Date()) + getExtension();
    }

    public byte[] generateBackupBytes() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        OutputStream out = new BufferedOutputStream(new GZIPOutputStream(outputStream));
        generateBackup(out);
        return outputStream.toByteArray();
    }

    private void generateBackup(OutputStream outputStream) throws Exception {
        OutputStreamWriter osw = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
        try (BufferedWriter bw = new BufferedWriter(osw, 65536)) {
            writeHeader(bw);
            writeBody(bw);
            writeFooter(bw);
        }
    }

    protected abstract void writeHeader(BufferedWriter bw) throws IOException, NameNotFoundException;

    protected abstract void writeBody(BufferedWriter bw) throws IOException;

    protected abstract void writeFooter(BufferedWriter bw) throws IOException;

    protected abstract String getExtension();

    // FIXME: After Q, top directory is not allowed, put it in Download folder first.
    // We should use MediaStore to access public directory but it needs bunches of changes.
    public static File getDefaultBackupFolder(Context context) {
        // return context.getExternalFilesDir("backup");
        File base = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        return new File(base, "financisto");
    }

    public static File getBackupFolder(Context context) {
        String path = MyPreferences.getDatabaseBackupFolder(context);
        File file = new File(path);
        file.mkdirs();
        if (file.isDirectory() && file.canWrite()) {
            return file;
        }
        file = getDefaultBackupFolder(context);
        file.mkdirs();
        return file;
    }

    public static File getBackupFile(Context context, String backupFileName) {
        File path = getBackupFolder(context);
        return new File(path, backupFileName);
    }

    public static void uploadBackupFileToDropbox(Context context, String backupFileName) throws Exception {
        File file = getBackupFile(context, backupFileName);
        Dropbox dropbox = new Dropbox(context);
        dropbox.uploadFile(file);
    }

    public static void uploadBackupFileToGoogleDrive(Context context, String backupFileName) throws Exception {
        File file = getBackupFile(context, backupFileName);
        GoogleDriveClientV3 driveClient = GoogleDriveClientV3_.getInstance_(context);
        driveClient.uploadFile(file);
    }

}
