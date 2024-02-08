package com.example.artfriendly.exhibition.Layer;
import com.example.artfriendly.exhibition.dto.PerformanceRequestDTO;
import com.example.artfriendly.exhibition.dto.PerformanceResponseDTO;
import org.springframework.http.ResponseEntity;

public interface PerformanceService {

   //1. Period
   public ResponseEntity<String> getPerformancePeriodList();
   public ResponseEntity<String> getPerformancePeriod3RowsList(String rows);
   //2. Area
   public ResponseEntity<String> getPerformanceAreaList();
   public ResponseEntity<String> getPerformanceAreaCPageSidoSortStdr3RowsList(String cPage,String sido,String sortStdr, String rows);

   //3. Realm

   public ResponseEntity<String> getPerformanceExampleRealmList();
   public PerformanceResponseDTO getPerformanceRealmData(PerformanceRequestDTO realmRequestDTO);
}
