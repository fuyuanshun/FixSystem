package com.fys.fixsystem.util;

/**
 * 分页辅助类
 */
public class Page {
    //总条目数
    private int totalCount;
    //每页的条目数
    private int pageSize = 10;
    //总页数
    private int totalPage;
    //当前页
    private int currentPage = 1;

    //初始化分页信息
    public void init(int totalCount, int pageSize) {
        //如果指定的每页条目数不为0，则初始化指定的每页条目数，否则为默认的10条
        if (0 != pageSize) {
            this.pageSize = pageSize;
        }
        //初始化总条目数
        this.totalCount = totalCount;
        //初始化总页数，计算公式为: 如果条目总数除以每页条目数等于0（即能整除），总页数为两个数的商，否则为两个数的商+1
        totalPage = this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
