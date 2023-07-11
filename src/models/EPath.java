package models;

public enum EPath {
    BOOKS("data/books.dat"),
    BORROWERS("data/borrowers.data");


    private final String filePath;

    EPath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }
}
