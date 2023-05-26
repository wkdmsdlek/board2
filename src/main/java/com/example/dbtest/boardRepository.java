package com.example.dbtest;

import java.lang.Long;
import org.springframework.data.jpa.repository.JpaRepository;

public interface boardRepository extends JpaRepository<board, Integer> {
}
