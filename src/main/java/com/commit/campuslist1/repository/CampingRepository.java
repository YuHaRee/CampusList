package com.commit.campuslist1.repository;

import com.commit.campuslist1.entity.Camping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampingRepository extends JpaRepository<Camping, Long> {

    // 오프셋 기반 페이지네이션 쿼리
    // 동적 정렬을 위해 CASE 문을 사용
    @Query(value = "SELECT * FROM camping WHERE do_name = :doName AND (:sigunguName IS NULL OR sigungu_name = :sigunguName) ORDER BY CASE WHEN :sort = 'createdDate' THEN created_date WHEN :sort = 'campName' THEN camp_name END :order LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Camping> findCampings(@Param("doName") String doName,
                               @Param("sigunguName") String sigunguName,
                               @Param("sort") String sort,
                               @Param("order") String order,
                               @Param("offset") int offset,
                               @Param("limit") int limit);

    // 캠핑장의 총 개수를 구하는 쿼리
    @Query(value = "SELECT COUNT(*) FROM camping WHERE do_name = :doName AND (:sigunguName IS NULL OR sigungu_name = :sigunguName)", nativeQuery = true)
    long countCampings(@Param("doName") String doName,
                       @Param("sigunguName") String sigunguName);
}
