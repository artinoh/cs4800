public class Main {
    public static void main(String[] args) {
        Folder folder = new Folder("demo1");


        folder.addFolderToPath("Source Files");
        folder.addFolderToPath("Include Path");
        folder.addFolderToPath("Remote Files");
        folder.addFolderToPath("Source Files/.phalcon");
        folder.addFolderToPath("Source Files/app/config");
        folder.addFolderToPath("Source Files/app/controllers");
        folder.addFolderToPath("Source Files/app/library");
        folder.addFolderToPath("Source Files/app/migrations");
        folder.addFolderToPath("Source Files/app/models");
        folder.addFolderToPath("Source Files/app/views");
        folder.addFolderToPath("Source Files/cache");
        folder.addFolderToPath("Source Files/public");
        folder.addFileToPath("Source Files/public/", ".htaccess");
        folder.addFileToPath("Source Files/public/", ".htrouter.php");
        folder.addFileToPath("Source Files/public/", "index.html");

        folder.print();
        System.out.println("\n\n--------------------\n\n");

        folder.removeSubFolderFromPath("Source Files", "app");

        folder.print();

        System.out.println("\n\n--------------------\n\n");

        folder.removeSubFolderFromPath("Source Files", "public");

        folder.print();

    }
}