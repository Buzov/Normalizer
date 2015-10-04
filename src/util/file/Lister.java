package util.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Класс Lister выводит отсортированный список содержимого пути, переданного ему
 * в качестве аргумента. Если аргумента нет, выводится сождержимое текущей
 * директории.
 *
 * @author RT
 */
class Lister {

    public static void print(File[] files) {
        for (File f : files) {
            System.out.println(f.getName() + ((f.isDirectory()) ? File.separator : ""));
        }
    }

    public static File[] getList(String pathname) throws IOException {
        File path = new File(pathname);
        File[] files;
        if (!path.exists()) {
            files = null;
            throw new IOException("Cannot access " + pathname + ": No such file or directory");
        }
        if (path.isFile()) {
            files = new File[]{path};
        } else {
            files = path.listFiles();
            Arrays.sort(files, new FilesComparator());
        }
        return files;
    }
    
    public static File[] getOnlyFileList(String pathname) throws IOException {
        File path = new File(pathname);
        File[] files;
        if (!path.exists()) {
            files = null;
            throw new IOException("Cannot access " + pathname + ": No such file or directory");
        }
        if (path.isFile()) {
            files = new File[]{path};
        } else {
            files = path.listFiles();
            Arrays.sort(files, new FilesComparator());
        }
        return files;
    }

    public static void main(String[] args) throws IOException {
        String path = "./"; //(args.length == 0) ? "." : args[0];
        print(getList(path));

    }

    private static class FilesComparator implements Comparator<File> {

        @Override
        public int compare(File f1, File f2) {
            if (f1.isDirectory() && f2.isFile()) {
                return -1;
            }
            if (f1.isFile() && f2.isDirectory()) {
                return 1;
            }
            return f1.compareTo(f2);
        }
    }
}
