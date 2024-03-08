package com.hyunwootem.hyunwootemproject.repository;

import com.hyunwootem.hyunwootemproject.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}
