package com.netflix.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.netflix.model.Chapters;

@Repository
@Qualifier("ChaptersRepository")
public interface ChaptersRepository  extends JpaRepository<Chapters, Long>{
	
	@Query(value= "SELECT c.* FROM CHAPTERS c "
			+" LEFT JOIN SEASONS a ON c.season_id=a.id "
			+" LEFT JOIN TV_SHOWS b ON a.tv_show_id=b.id "
			+" WHERE b.id=?1 and a.number=?2 ", nativeQuery=true)
	List<Chapters> listTvShowsAndNumber(long tvShowId, int seasonNumber);
	
	@Query(value= "SELECT c.* FROM CHAPTERS c "
			+" LEFT JOIN SEASONS a ON c.season_id=a.id "
			+" LEFT JOIN TV_SHOWS b ON a.tv_show_id=b.id "
			+" WHERE b.id=?1 and a.number=?2 "
			+" and c.number=?3", nativeQuery=true)
	Chapters findChaptersByTvShowsAndNumberAndChapterNumber(long tvShowId, int seasonNumber, int chapterNumber);
}
