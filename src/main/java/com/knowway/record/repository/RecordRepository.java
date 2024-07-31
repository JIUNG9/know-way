package com.knowway.record.repository;

import com.knowway.record.entity.Record;
import com.knowway.user.dto.UserRecordDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {


  @Query("SELECT new com.knowway.user.dto.UserRecordDto(" +
      "r.id, r.recordPath, r.recordIsSelected, " +
      "ds.departmentStoreName,ds.departmentStoreBranch,dsf.departmentStoreFloor) " +
      "FROM Record r " +
      "JOIN r.departmentStoreFloor dsf " +
      "JOIN dsf.departmentStore ds " +
      "WHERE r.member.id = :memberId")
  Page<UserRecordDto> findUserRecordsByMemberId(@Param("memberId") Long memberId,
      Pageable pageable);
}