package com.lockme.prototype;

public abstract class AbstractFileManager {
    protected abstract String[] getFileNames();

    protected abstract String[] getFileNamesInAscendingOrder();

    protected abstract void addFile(String fileName);

    protected abstract void deleteFile(String fileName);

    protected abstract void searchFile(String fileName);
}
