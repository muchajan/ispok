/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispok.service;

import ispok.bo.Tournament;
import ispok.dao.GenericDao;
import ispok.dto.TournamentDto;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TournamentServiceImpl implements TournamentService {

    private static final Logger logger = LogManager.getLogger();

    @Autowired
    GenericDao genericDao;

//    @Override
//    public List<TournamentDto> getAllTournaments() {
//        GenericDao.ge
//    }
    @Override
    public TournamentDto getTournamentById(Long id) {
        Tournament tournament = genericDao.getById(id, Tournament.class);
        return getTournamentDao(tournament);
    }

    @Override
    public List<TournamentDto> getPage(int first, int pageSize, String sortField, boolean ascending, Map<String, Object> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getTournamentCount(Map<String, Object> filters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private TournamentDto getTournamentDao(Tournament tournament) {

        TournamentDto tournamentDto = new TournamentDto();
        tournamentDto.setId(tournament.getId());
        tournamentDto.setName(tournament.getName());
        tournamentDto.setStart(tournament.getStart());
        tournamentDto.setLateReg(tournament.getLateReg());
        tournamentDto.setFinish(tournament.getFinish());
        tournamentDto.setBuyin(tournament.getBuyin());
        tournamentDto.setAddon(tournament.getAddon());
        tournamentDto.setBonusPoints(tournament.getBonusPoints());
        tournamentDto.setLevelNumber(tournament.getLevelTime());
        tournamentDto.setLevelTime(tournament.getLevelTime());
        tournamentDto.setTournamentStructureId(tournament.getTournamentStructure().getId());
        tournamentDto.setSeriesId(tournament.getSeries().getId());
        tournamentDto.setPlaceId(tournament.getPlace().getId());

        return null;
    }

}