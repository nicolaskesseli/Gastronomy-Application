package ch.hslu.informatik.gastgewerbe.businesstisch;

import ch.hslu.informatik.gastgewerbe.api.TischService;
import ch.hslu.informatik.gastgewerbe.model.Tisch;
import ch.hslu.informatik.gastgewerbe.persister.TischDAO;

import ch.hslu.informatik.gastgewerbe.persister.impl.TischDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TischManager implements TischService {

    private static Logger logger = LogManager.getLogger(TischManager.class);

    private TischDAO tischDAO;

    public TischDAO getTischDAO() {

        if (tischDAO == null) {
            tischDAO = new TischDAOImpl();
        }

        return tischDAO;
    }

    @Override
    public Tisch tischHinzufuegen(Tisch tisch) throws Exception {
        try {
            return getTischDAO().save(tisch);
        } catch (Exception e) {
            String msg = "Tisch \'" + tisch.getTischNr()
                    + "\' konnte nicht hinzugefügt werden";
            logger.error(msg, e);
            throw new Exception(msg);
        }
    }

    @Override
    public void tischLoeschen(Tisch tisch) throws Exception {
        try {
            getTischDAO().delete(tisch);
        } catch (Exception e) {
            String msg = "Tisch \'" + tisch.getTischNr()
                    + "\' konnte nicht gelöscht werden";
            logger.error(msg, e);
            throw new Exception(msg);
        }
    }

    @Override
    public List<Tisch> alleTische() throws Exception{
        try {
            return getTischDAO().findAll();
        } catch (Exception e) {
            String msg = "Tisch konnten nicht gefunden werden";
            logger.error(msg, e);
            throw new Exception(msg);
        }
    }

    @Override
    public Tisch findByTischNummer(int tischNr) throws Exception{
        try {
            return getTischDAO().findByTischNr(tischNr);
        } catch (Exception e) {
            String msg = "Tisch konnte nicht gefunden werden";
            logger.error(msg, e);
            throw new Exception(msg);
        }
	}
}