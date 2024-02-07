package com.example.artfriendly.exhibition.Layer;
import org.springframework.http.ResponseEntity;

public interface PerformanceService {

   //1. Period
   public ResponseEntity<String> getPerformancePeriodList();
   public ResponseEntity<String> getPerformancePeriod3RowsList(String rows);
   //2. Area
   public ResponseEntity<String> getPerformanceAreaList();
   public ResponseEntity<String> getPerformanceAreaSidoSortStdr3RowsList(String sido,String sortStdr, String rows);

   //3. Realm
   public ResponseEntity<String> getPerformanceRealmSortStdr3RowsList(String realmCode, String rows);

}
