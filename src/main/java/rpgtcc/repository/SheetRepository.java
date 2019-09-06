package rpgtcc.repository;

import rpgtcc.model.Match;
import rpgtcc.model.Sheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SheetRepository extends CrudRepository<Sheet,Long> {

   // @Query("SELECT sheet_id,charism,constitution,current_energy_points,dexterity,intelligence,max_energy_points,max_health_points,name,strength,wisdom,sheet_user_id FROM Sheet WHERE sheet_user_id = ?1")
    List<Sheet> findAllSheetBySheetUserId(Long id);

    //@Query(value ="select sheets0_.match_match_id as match_m13_2_0_, sheets0_.sheet_id as sheet_id1_2_0_, sheets0_.sheet_id as sheet_id1_2_1_, sheets0_.charism as charism2_2_1_, sheets0_.constitution as constitu3_2_1_, sheets0_.current_energy_points as current_4_2_1_, sheets0_.current_health_points as current_5_2_1_, sheets0_.dexterity as dexterit6_2_1_, sheets0_.intelligence as intellig7_2_1_, sheets0_.match_match_id as match_m13_2_1_, sheets0_.max_energy_points as max_ener8_2_1_, sheets0_.max_health_points as max_heal9_2_1_, sheets0_.name as name10_2_1_, sheets0_.sheet_user_id as sheet_u14_2_1_, sheets0_.strength as strengt11_2_1_, sheets0_.wisdom as wisdom12_2_1_, user1_.id as id1_1_2_, user1_.dateaccount as dateacco2_1_2_, user1_.email as email3_1_2_, user1_.name as name4_1_2_, user1_.password as password5_1_2_ from bizmeaoxektymsx9iifm.sheet sheets0_ left outer join player user1_ on sheets0_.sheet_user_id=user1_.id where sheets0_.match_match_id=1", nativeQuery = true)
    List<Sheet> findSheetByMatch(Match match);


}
