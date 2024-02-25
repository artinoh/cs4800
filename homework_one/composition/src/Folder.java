import java.util.ArrayList;
import java.util.Optional;

public class Folder {

    private class PathData {
        private String nextFolder;
        private String remainingPath;

        PathData(String nextFolder, String remainingPath) {
            this.nextFolder = nextFolder;
            this.remainingPath = remainingPath;
        }

        public String getNextFolder() {
            return nextFolder;
        }

        public String getRemainingPath() {
            return remainingPath;
        }

    }

    private String name;
    private ArrayList<File> files;
    private ArrayList<Folder> subFolders;

    public Folder(String name) {
        this.name = name;
        files = new ArrayList<File>();
        subFolders = new ArrayList<Folder>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public ArrayList<Folder> getSubFolders() {
        return subFolders;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFile(String name) {
        files.add(new File(name));
    }

    public void addSubFolder(String name) {
        subFolders.add(new Folder(name));
    }

    private boolean endOfPath(String path) {
        return path == null || path.isEmpty() || path.equals("/");
    }

    private Optional<PathData> getPathData(String path) {
        if (endOfPath(path)) {
            return Optional.empty();
        }

        String[] pathParts = path.split("/", 2);
        return Optional.of(new PathData(pathParts[0], pathParts.length > 1 ? pathParts[1] : ""));
    }

    public boolean addFileToPath(String path, String name) {
        Optional<PathData> pathData = getPathData(path);
        if (pathData.isEmpty()) {
            addFile(name);
            return true;
        }

        for (Folder folder : subFolders) {
            if (folder.getName().equals(pathData.get().getNextFolder())) {
                return folder.addFileToPath(pathData.get().getRemainingPath(), name);
            }
        }

        System.out.println("Path not found " + path);
        return false;
    }

    public boolean removeFileFromPath(String path, String fileName) {
        Optional<PathData> pathData = getPathData(path);
        if (pathData.isPresent()) {
            for (Folder folder : subFolders) {
                if (folder.getName().equals(pathData.get().getNextFolder())) {
                    return folder.removeFileFromPath(pathData.get().getRemainingPath(), fileName);
                }
            }
        }

        System.out.println("Path not found: " + path);
        return false;
    }

    public boolean removeSubFolderFromPath(String path, String folderName) {
        Optional<PathData> pathData = getPathData(path);
        if (pathData.isPresent()) {
            for (Folder folder : subFolders) {
                if (folder.getName().equals(pathData.get().getNextFolder())) {
                    if (pathData.get().getRemainingPath().isEmpty()) {
                        return folder.removeSubFolder(folderName);
                    }
                    else {
                        return folder.removeSubFolderFromPath(pathData.get().getRemainingPath(), folderName);
                    }
                }
            }
        }

        System.out.println("Path not found: " + path);
        return false;
    }


    public boolean addFolderToPath(String path) {
        Optional<PathData> pathData = getPathData(path);
        if (pathData.isEmpty()) {
            System.out.println("Invalid folder name " + path);
            return false;
        }

        for (Folder folder : subFolders) {
            if (folder.getName().equals(pathData.get().getNextFolder())) {
                return folder.addFolderToPath(pathData.get().getRemainingPath());
            }
        }

        addSubFolder(pathData.get().getNextFolder());
        return true;
    }

    public boolean removeSubFolder(String name) {
        return subFolders.removeIf(folder -> folder.getName().equals(name));
    }

    public boolean removeFile(String name) {
        return files.removeIf(file -> file.getName().equals(name));
    }

    public void print() {
        printRecursive(0);
    }

    private void printRecursive(int level) {
        String indent = "\t".repeat(level);
        System.out.println(indent + "Folder: " + name);

        if (!files.isEmpty()) {
            for (File file : files) {
                System.out.println(indent + "\tFiles: " + file.getName());
            }
        }
        if (!subFolders.isEmpty()) {
            for (Folder subFolder : subFolders) {
                subFolder.printRecursive(level + 1);
            }
        }
    }

}
