package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    public Resume[] storage = new Resume[STORAGE_LIMIT];
    int size = 0;

    public void clear() {
        Arrays.fill(storage, null);
        size = 0;
    }

    public int findResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public void save(Resume resume) {
        int resumeIndex = findResume(resume.toString());
        if (size == STORAGE_LIMIT) {
            System.out.println("Массив заполнен!");
        } else if (resumeIndex < 0) {
            storage[size] = resume;
            size++;
        } else {

            System.out.println("Резюме уже есть в массиве!");
        }
    }

    public void update(Resume resume) {
        int resumeIndex = findResume(resume.toString());
        if (resumeIndex != -1) {
            storage[resumeIndex] = resume;
        } else {
            System.out.println("Резюме не найдено в массиве!");
        }
    }


    public Resume get(String uuid) {
        int resumeIndex = findResume(uuid);
        if (resumeIndex != -1) {
            return storage[resumeIndex];
        } else {
            System.out.println("Резюме не найдено в массиве!");
            return null;
        }
    }

    public void delete(String uuid) {
        int resumeIndex = findResume(uuid);
        if (resumeIndex != -1) {
            storage[resumeIndex] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме не найдено в массиве!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }


}
