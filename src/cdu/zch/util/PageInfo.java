package cdu.zch.util;

import java.util.List;

public class PageInfo<T> {

    private int currentPage; // 当前页数 由用户指定
    private int pageNum; // 总页数
    private int count; // 数据总数 数据库中查出
    private int pageSize; // 每页最大数据条数 由用户指定

    private List<T> list; // 已经分好页的结果集
    public PageInfo() {
    }

    public PageInfo(int currentPage, int pageNum, int count, int pageSize) {
        this.currentPage = currentPage;
        this.pageNum = pageNum;
        this.count = count;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageNum() {
        // 计算出总页数
        return this.count % this.pageSize == 0 ? this.count / this.pageSize : this.count / this.pageSize + 1;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "currentPage=" + currentPage +
                ", pageNum=" + pageNum +
                ", count=" + count +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
