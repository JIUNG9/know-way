package com.knowway.admin.service;

import com.knowway.admin.dto.AdminRecordResponse;

import java.util.List;

public interface AdminService {
    List<AdminRecordResponse> getRecordsByFloor(Long departmentStoreFloorId, Long recordArea, Boolean recordIsSelected);
    boolean toggleRecordIsSelected(Long id);
}