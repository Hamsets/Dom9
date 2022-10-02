import java.io.*;
import java.util.ArrayList;

public class MyFiles {
    private ArrayList<File> filesList = new ArrayList<>();

    public void readListFiles (String path) {
        File file = new File(path);
        for (File f : file.listFiles()) {
            if (f.isFile()) {
            filesList.add(f);
            }
        }
    }

    public void readDir (String path){
        File file =new File(path);
        if (file.isDirectory()){
            readListFiles(file.getPath());
            for (File f : file.listFiles()) {
                if (f.isDirectory()) {
                    readDir(f.getPath());
                }
            }
        }
    }

    public void saveList (){
       try {
           BufferedWriter writer = new BufferedWriter(new FileWriter("files.txt"));
           System.out.println("Saving list of files from root directory in files.txt...");
           for (File f : filesList){
               writer.write(f.getName() + "\n");
           }
           writer.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
    }

}
