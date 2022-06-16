package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    public void clear();

    public int getIndex(String uuid);

    public void save(Resume resume);

    public void update(Resume resume);

    public Resume get(String uuid);

    public void delete(String uuid);

    public Resume[] getAll();

    public int size();

}
