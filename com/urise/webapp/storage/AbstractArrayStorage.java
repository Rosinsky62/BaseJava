package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;


    }

    public int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.toString());
        if (size == STORAGE_LIMIT) {
            System.out.println("Массив заполнен!");
        } else if (index == -1) {
            System.out.println("Резюме уже есть в массиве!");
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.toString());
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("Резюме не найдено в массиве!");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Резюме не найдено в массиве!");
        } else {
            fillDeletedResume(index);
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("The resume not exist");
            return null;
        } else {
            return storage[index];
        }
    }

    protected abstract void insertResume(Resume resume, int index);

    protected abstract void fillDeletedResume(int index);
}
