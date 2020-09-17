package ua.com.alevel.iotasks.task2;

import java.io.File;
import java.util.*;

public class FileTree {
    public static void main(String[] args) {
        File file = new File("/users/vitalij/Documents");
        new FileTree().showNestedTree(file);
    }

    public void showNestedTree(File source) {
        Queue<File> fileTree = new PriorityQueue<>();
        Collections.addAll(fileTree, source.listFiles());
        while(!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if (currentFile.isDirectory()) {
                System.out.println(currentFile.getName() + " is directory");
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                System.out.println(currentFile.getName() + " is file");
            }
        }
    }
}

