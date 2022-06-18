package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertResume(Resume resume, int index) {
        storage[index] = resume;
    }

    @Override
    protected void fillDeletedResume(int index) {
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
    }
}


