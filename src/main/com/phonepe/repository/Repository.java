package main.com.phonepe.repository;

import main.com.phonepe.models.Branch;

import java.util.Map;

public class Repository {
    Map<String, Branch> branchMap;

    public Map<String, Branch> getBranchMap() {
        return branchMap;
    }

    public void setBranchMap(Map<String, Branch> branchMap) {
        this.branchMap = branchMap;
    }

    public Repository(Map<String, Branch> branchMap) {
        this.branchMap = branchMap;
    }
}
