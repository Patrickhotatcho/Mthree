package com.mthree.DVDLib.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.DVDLib.DVD.DVD;

@Repository(value="jparepos")
public interface DVDJpaRepository extends JpaRepository<DVD, Integer>,IDao {

}
