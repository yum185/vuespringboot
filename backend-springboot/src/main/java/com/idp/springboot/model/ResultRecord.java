package com.idp.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class ResultRecord<T> {

    private int currenPageNum;
    private int totalPages;
    private int currentSize;
    private long totalElements;
    private List<T> records;

    public ResultRecord() {
        records = new ArrayList<>();
    }

    public ResultRecord(int currenPageNum, int currentSize, int totalPages, long totalElements, List<T> records) {
        this.currenPageNum = currenPageNum;
        this.totalPages = totalPages;
        this.currentSize = currentSize;
        this.totalElements = totalElements;
        this.records = records;
    }

    public int getCurrenPageNum() {
        return currenPageNum;
    }

    public void setCurrenPageNum(int currenPageNum) {
        this.currenPageNum = currenPageNum;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
