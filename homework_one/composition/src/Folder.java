import java.util.ArrayList;

public class Folder {
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

    public boolean removeSubFolder(String name) {
        for (Folder folder : subFolders) {
            if (folder.getName().equals(name)) {
                subFolders.remove(folder);
                return true;
            }
        }
        return false;
    }

    public void print() {
        StringBuilder result = new StringBuilder("Folder: " + name + "\n");
        result.append("Files:\n");
        for (File file : files) {
            result.append(file.getName()).append("\n");
        }
        result.append("Subfolders:\n");
        for (Folder folder : subFolders) {
            result.append(folder.getName()).append("\n");
            for (File file : folder.getFiles()) {
                result.append("\t").append(file.getName()).append("\n");
            }
        }
        System.out.println(result);
    }

}
